package net.scoreworks.omr.rectification.stages;

import net.scoreworks.omr.rectification.utils.LinePoint;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.*;

/**
 * Detect curvilinear points as described by Steger
 *  +----> x, col
 *  |
 *  v
 *  y, row
 */
public class StegerPointDetection {
    private final Mat mat;
    private final Mat dx  = new Mat();
    private final Mat dy  = new Mat();
    private final Mat dxx = new Mat();
    private final Mat dyy = new Mat();
    private final Mat dxy = new Mat();

    public StegerPointDetection(Mat mat, float sigma) {
        this.mat = mat;
        //convolve the image
        createLocalDerivatives(sigma);
    }

    public void visualize(Mat img, float thresholdHor, float thresholdVer, Scalar colorHor, Scalar colorVer, int thickness) {
        for (LinePoint lp : getHorizontalPoints(thresholdHor).values()) {
            Imgproc.circle(img, new Point(lp.x, lp.y), thickness, colorHor);
        }
        for (LinePoint lp : getVerticalPoints(thresholdVer)) {
            Imgproc.circle(img, new Point(lp.x, lp.y), thickness, colorVer);
        }
    }

    private void createLocalDerivatives(float sigma) {
        int width = Math.round(3*sigma);
        int kernelSize = 2*width+1;

        double[] g0 = new double[kernelSize];
        double[] g1 = new double[kernelSize];
        double[] g2 = new double[kernelSize];

        //calculate kernel values
        double f = Math.sqrt(2*Math.PI);
        for (int i=0; i<kernelSize; i++) {
            int x = i-width;
            double e = Math.exp(-(x*x)/(2*sigma*sigma));
            g0[i] = e/(f*sigma);
            g1[i] = e*(-x)/(f*Math.pow(sigma, 3));
            g2[i] = e*(x*x-sigma*sigma)/(f*Math.pow(sigma, 5));
        }
        //create vector kernels
        Mat k0 = new Mat(1, kernelSize, CvType.CV_32FC1);
        k0.put(0, 0, g0);
        //1st derivative
        Mat k1 = new Mat(1, kernelSize, CvType.CV_32FC1);
        k1.put(0, 0, g1);
        //2nd derivative
        Mat k2 = new Mat(1, kernelSize, CvType.CV_32FC1);
        k2.put(0, 0, g2);

        //do convolutions (which are separable)
        Imgproc.sepFilter2D(mat, dx , CvType.CV_32F, k1, k0);
        Imgproc.sepFilter2D(mat, dy , CvType.CV_32F, k0, k1);
        Imgproc.sepFilter2D(mat, dxx, CvType.CV_32F, k2, k0);
        Imgproc.sepFilter2D(mat, dyy, CvType.CV_32F, k0, k2);
        Imgproc.sepFilter2D(mat, dxy, CvType.CV_32F, k1, k1);
    }

    /**
     * get horizontal line points implicitly sorted by increasing x value
     */
    public NavigableMap<Float, LinePoint> getHorizontalPoints(float threshold) {
        NavigableMap<Float, LinePoint> points = new TreeMap<>();
        //declare auxiliary variables once in loops to use
        float temp, lambda1, lambda2, nx, ny, magnitude;
        float T, px, py;
        //quick access to derivatives
        int idx;
        float[] Dx  = new float[(int)dx.total()];  dx.get(0, 0, Dx);
        float[] Dy  = new float[(int)dy.total()];  dy.get(0, 0, Dy);
        float[] Dxx = new float[(int)dxx.total()]; dxx.get(0, 0, Dxx);
        float[] Dyy = new float[(int)dyy.total()]; dyy.get(0, 0, Dyy);
        float[] Dxy = new float[(int)dxy.total()]; dxy.get(0, 0, Dxy);

        for (int x=0; x<mat.cols(); x++) {
            for (int y=0; y<mat.rows(); y++) {
                idx = y*mat.cols() + x;
                //calculate eigenvalues and sort by greater absolute value (=dominant direction, normal to line)
                temp = (float) Math.sqrt((Dxx[idx] - Dyy[idx]) * (Dxx[idx] - Dyy[idx]) + 4 * Dxy[idx] * Dxy[idx]);
                lambda1 = (Dxx[idx] + Dyy[idx] + temp) * 0.5f;
                lambda2 = (Dxx[idx] + Dyy[idx] - temp) * 0.5f;
                //make lambda1 be the one with greater absolute value (=dominant direction)
                if (Math.abs(lambda2) > Math.abs(lambda1)) {
                    lambda1 = lambda2;
                }
                //lambda represents strength of second order derivative normal to line. Lines will have strong negative
                //eigenvalue
                if (lambda1 > threshold) {
                    continue;
                }
                //create eigenvectors
                nx = Dxy[idx];
                ny = lambda1 - Dxx[idx];
                //normalize
                magnitude = (float) Math.sqrt(nx * nx + ny * ny);
                if (magnitude != 0) {
                    nx /= magnitude;
                    ny /= magnitude;
                }
                //filter non horizontal lines
                if (Math.abs(nx) > Math.abs(ny))
                    continue;
                //use a quadratic polynomial (second order taylor approximation) to determine weather first directional derivative
                //(perpendicular to line) vanishes inside pixel
                T = -(Dx[idx] * nx + Dy[idx] * ny) / (Dxx[idx] * nx * nx + 2 * Dxy[idx] * nx * ny + Dyy[idx] * ny * ny);
                px = T * nx;
                py = T * ny;
                //add to point collection if maximum along normal gets 0 within pixel boundaries
                if (px >= -0.5 & px <= 0.5 & py >= -0.5 & py <= 0.5) {
                    points.put(x + px + 0.5f, new LinePoint(x + px + 0.5f, y + py + 0.5f, nx/-ny));
                }
            }
        }
        return points;
    }

    /**
     * get vertical line points implicitly sorted by increasing x value
     */
    public List<LinePoint> getVerticalPoints(float threshold) {
        List<LinePoint> points = new ArrayList<>();
        //declare auxiliary variables once in loops to use
        float temp, lambda1, lambda2, nx, ny, magnitude;
        float T, px, py;
        //quick access to derivatives
        int idx;
        float[] Dx = new float[(int) dx.total()];dx.get(0, 0, Dx);
        float[] Dy = new float[(int) dy.total()];dy.get(0, 0, Dy);
        float[] Dxx = new float[(int) dxx.total()];dxx.get(0, 0, Dxx);
        float[] Dyy = new float[(int) dyy.total()];dyy.get(0, 0, Dyy);
        float[] Dxy = new float[(int) dxy.total()];dxy.get(0, 0, Dxy);

        for (int x = 0; x < mat.cols(); x++) {
            for (int y = 0; y < mat.rows(); y++) {
                idx = y * mat.cols() + x;
                //calculate eigenvalues and sort by greater absolute value (=dominant direction, normal to line)
                temp = (float) Math.sqrt((Dxx[idx] - Dyy[idx]) * (Dxx[idx] - Dyy[idx]) + 4 * Dxy[idx] * Dxy[idx]);
                lambda1 = (Dxx[idx] + Dyy[idx] + temp) * 0.5f;
                lambda2 = (Dxx[idx] + Dyy[idx] - temp) * 0.5f;
                //make lambda1 be the one with greater absolute value (=dominant direction)
                if (Math.abs(lambda2) > Math.abs(lambda1)) {
                    lambda1 = lambda2;
                }
                //lambda represents strength of second order derivative normal to line. Lines will have strong negative
                //eigenvalue
                if (lambda1 > threshold) {
                    continue;
                }
                //create eigenvectors
                nx = Dxy[idx];
                ny = lambda1 - Dxx[idx];
                //normalize
                magnitude = (float) Math.sqrt(nx * nx + ny * ny);
                if (magnitude != 0) {
                    nx /= magnitude;
                    ny /= magnitude;
                }
                //filter non vertical lines
                if (Math.abs(nx) < Math.abs(ny))
                    continue;
                //use a quadratic polynomial (second order taylor approximation) to determine weather first directional derivative
                //(perpendicular to line) vanishes inside pixel
                T = -(Dx[idx] * nx + Dy[idx] * ny) / (Dxx[idx] * nx * nx + 2 * Dxy[idx] * nx * ny + Dyy[idx] * ny * ny);
                px = T * nx;
                py = T * ny;
                //add to point collection if maximum along normal gets 0 within pixel boundaries
                if (px >= -0.5 & px <= 0.5 & py >= -0.5 & py <= 0.5) {
                    points.add(new LinePoint(x + px + 0.5f, y + py + 0.5f, -ny / nx));
                }
            }
        }
        return points;
    }

    /**
     * get vertical line points implicitly sorted by increasing y value
     */
    public List<LinePoint> getVerticalPointsY(float threshold) {
        List<LinePoint> points = new ArrayList<>();
        //declare auxiliary variables once in loops to use
        float temp, lambda1, lambda2, nx, ny, magnitude;
        float T, px, py;
        //quick access to derivatives
        int idx;
        float[] Dx = new float[(int) dx.total()];dx.get(0, 0, Dx);
        float[] Dy = new float[(int) dy.total()];dy.get(0, 0, Dy);
        float[] Dxx = new float[(int) dxx.total()];dxx.get(0, 0, Dxx);
        float[] Dyy = new float[(int) dyy.total()];dyy.get(0, 0, Dyy);
        float[] Dxy = new float[(int) dxy.total()];dxy.get(0, 0, Dxy);

        for (int y = 0; y < mat.rows(); y++) {
            for (int x = 0; x < mat.cols(); x++) {
                idx = y * mat.cols() + x;
                //calculate eigenvalues and sort by greater absolute value (=dominant direction, normal to line)
                temp = (float) Math.sqrt((Dxx[idx] - Dyy[idx]) * (Dxx[idx] - Dyy[idx]) + 4 * Dxy[idx] * Dxy[idx]);
                lambda1 = (Dxx[idx] + Dyy[idx] + temp) * 0.5f;
                lambda2 = (Dxx[idx] + Dyy[idx] - temp) * 0.5f;
                //make lambda1 be the one with greater absolute value (=dominant direction)
                if (Math.abs(lambda2) > Math.abs(lambda1)) {
                    lambda1 = lambda2;
                }
                //lambda represents strength of second order derivative normal to line. Lines will have strong negative
                //eigenvalue
                if (lambda1 > threshold) {
                    continue;
                }
                //create eigenvectors
                nx = Dxy[idx];
                ny = lambda1 - Dxx[idx];
                //normalize
                magnitude = (float) Math.sqrt(nx * nx + ny * ny);
                if (magnitude != 0) {
                    nx /= magnitude;
                    ny /= magnitude;
                }
                //filter non vertical lines
                if (Math.abs(nx) < Math.abs(ny))
                    continue;
                //use a quadratic polynomial (second order taylor approximation) to determine weather first directional derivative
                //(perpendicular to line) vanishes inside pixel
                T = -(Dx[idx] * nx + Dy[idx] * ny) / (Dxx[idx] * nx * nx + 2 * Dxy[idx] * nx * ny + Dyy[idx] * ny * ny);
                px = T * nx;
                py = T * ny;
                //add to point collection if maximum along normal gets 0 within pixel boundaries
                if (px >= -0.5 & px <= 0.5 & py >= -0.5 & py <= 0.5) {
                    points.add(new LinePoint(y + py + 0.5f, x + px + 0.5f, -ny / nx));
                }
            }
        }
        return points;
    }
}