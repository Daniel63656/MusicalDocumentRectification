package net.scoreworks.omr.utils;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.CLAHE;
import org.opencv.imgproc.Imgproc;

import java.util.*;

public final class Utils {
    //make instantiation impossible
    private Utils() {}

    //provide a set of unique colors for visualizations
    private static final int[] COLORS = new int[]{0xe6194B, 0x3cb44b, 0xffe119, 0xbfef45, 0x4363d8, 0xf58231, 0x911eb4, 0x42d4f4, 0xf032e6, 0xFF0000, 0x00FF00, 0x0000FF};
    public static Scalar getColor(int idx) {
        int color = COLORS[idx % COLORS.length];
        return new Scalar((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF);
    }

    public static int nearestOddNumber(double x) {
        int i = (int) x;
        if (i % 2 == 0)
            return i + 1;
        else return i;
    }

    public static float linearInterpolation(float f1, float f2, float x1, float x2, float x) {
        return f1 + (x - x1)*(f2 - f1)/(x2 - x1);
    }

    public static float[] linearRegression(float[] x, float[] y) {
        int n = x.length;
        //calculate mean
        float meanX = 0, meanY = 0;

        for (int i=0; i<x.length; i++) {
            meanX += x[i];
            meanY += y[i];
        }
        meanX /= n;
        meanY /= n;
        //calculate covariance and variances
        float covariance = 0, varX = 0, varY = 0;
        for (int i=0; i<x.length; i++) {
            covariance += (x[i] - meanX) * (y[i] - meanY);
            varX += (x[i] - meanX) * (x[i] - meanX);
            varY += (y[i] - meanY) * (y[i] - meanY);
        }
        //calculate statistical data
        float correlation = (float) (covariance/Math.sqrt(varX*varY));
        float slope  = covariance / varX;
        float intercept = meanY - slope * meanX;
        return new float[]{slope, intercept, correlation*correlation};
    }

    public static float median(List<Float> values) {
        values.sort(Comparator.comparingDouble(Float::floatValue));
        float median = values.get(values.size()/2);
        if(values.size()%2 == 0)
            median = (median + values.get(values.size()/2-1)) / 2;
        return median;
    }


    public static Mat createHistogram(Mat img) {
        float[] range = {0, 256}; //the upper boundary is exclusive
        Mat histogram = new Mat();
        Imgproc.calcHist(Collections.singletonList(img), new MatOfInt(0), new Mat(), histogram, new MatOfInt(256), new MatOfFloat(range), false);
        return histogram;
    }

    public static void visualizeHistogram(Mat histogram) {
        int histW = 512, histH = 400;
        int binW = (int) Math.round((double) histW / 256);
        Mat histImage = new Mat(histH, histW, CvType.CV_8UC1);
        Core.normalize(histogram, histogram, 0, histImage.rows(), Core.NORM_MINMAX);

        float[] histData = new float[(int) (histogram.total())];
        histogram.get(0, 0, histData);

        for(int i=1; i<256; i++) {
            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(histData[i - 1])),
                    new Point(binW * (i), histH - Math.round(histData[i])), new Scalar(255, 0, 0), 2);
        }
        HighGui.imshow( "Histogram", histImage);
        HighGui.waitKey(0);
    }

    public static float interpolatePeakLocation(Map<Integer, Integer> histogram) {
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : histogram.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        //interpolate peak according to https://ccrma.stanford.edu/~jos/sasp/Quadratic_Interpolation_Spectral_Peaks.html
        //if surrounding values don't exist in histogram, they are 0
        assert maxEntry != null;
        int x = maxEntry.getKey();
        int y_prior = 0; int y_next = 0;
        if (histogram.containsKey(x-1))
            y_prior = histogram.get(x-1);
        if (histogram.containsKey(x+1))
            y_next = histogram.get(x+1);
        //interpolation assumes middle point to be at x=0, so add its true position
        return x + 0.5f*(y_prior - y_next)/(y_prior - 2*maxEntry.getValue() + y_next);
    }

    public static void clahe(Mat src, Mat dst, float clipLimit, float tileGridSize) {
        CLAHE clahe = Imgproc.createCLAHE();
        clahe.setClipLimit(clipLimit);
        clahe.setTilesGridSize(new Size(tileGridSize, tileGridSize));
        clahe.apply(src, dst);
    }

    public static Map<Boolean, Map<Integer, Integer>> columnMajorRLE(Mat mat, float threshold) {
        Map<Boolean, Map<Integer, Integer>> histogram = new HashMap<>();
        histogram.put(true, new HashMap<>());
        histogram.put(false, new HashMap<>());
        int runLength;
        boolean white;
        int depth;

        //iterate over mat
        for (int col=0; col<mat.cols(); col++) {
            for (int row=0; row<mat.rows(); row++) {
                runLength = 1;
                white = mat.get(row, col)[0] > threshold;  //true=white, false = black
                while (row+1 < mat.rows() && mat.get(row+1, col)[0] > threshold == white) {
                    runLength++;
                    row++;
                }
                //increment histogram entry or initialize with 1 if not existing
                depth = 1;
                if (histogram.get(white).containsKey(runLength))
                    depth = histogram.get(white).get(runLength)+1;
                histogram.get(white).put(runLength, depth);
            }
        }
        return histogram;
    }

    private static float[] jointlyEstimateOtsuThresholdAndContrast(Mat histogram, int totalPixels) {
        float[] histData = new float[(int) (histogram.total())];
        histogram.get(0, 0, histData);

        float sum = 0;
        for (int t=0; t<256; t++)
            sum += t * histData[t];

        float sumB = 0;
        int weightB = 0;
        int weightF;
        float varMax = 0;
        int threshold = 0;
        float contrast = 0;
        float meanB, meanF, variance;

        for (int t=0; t<256; t++) {
            //calculate weight
            weightB += histData[t];
            if (weightB == 0)
                continue;
            weightF = totalPixels - weightB;
            if (weightF == 0)
                break;
            sumB += t * histData[t];
            //calculate mean
            meanB = sumB / weightB;
            meanF = (sum - sumB) / weightF;

            //calculate between class variance
            variance = (meanB - meanF) * (meanB - meanF) * weightB * weightF;

            // Check if new maximum found
            if (variance > varMax) {
                varMax = variance;
                threshold = t;
                contrast = Math.abs(meanB - meanF);
            }
        }
        return new float[]{threshold, contrast};
    }
}