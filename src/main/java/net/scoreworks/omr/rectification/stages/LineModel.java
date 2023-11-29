package net.scoreworks.omr.rectification.stages;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.HashMap;
import java.util.Map;

import static net.scoreworks.omr.rectification.utils.Utils.interpolatePeakLocation;

public class LineModel {
    private static final int KERNEL_SIZE = 55;
    private static final float C_s = -8;

    private final float staffLineThickness;
    private final float interlineStaffSpace;
    private float staffLineContrast;

    public LineModel(Mat img) {
        Map<Boolean, Map<Integer, Integer>> histRLE = adaptiveColumnMajorRLE(img, KERNEL_SIZE, C_s, 15);
        staffLineThickness = interpolatePeakLocation(histRLE.get(true));
        interlineStaffSpace = staffLineThickness + interpolatePeakLocation(histRLE.get(false));
    }

    public float getStaffLineThickness() {
        return staffLineThickness;
    }

    public float getInterlineStaffSpace() {
        return interlineStaffSpace;
    }

    public float getStaffLineContrast() {
        return staffLineContrast;
    }

    public static float getLowerSigma(float lineWidth) {
        //according to (13) in paper, lineWidth = 2*w
        return (float)(lineWidth/(2*Math.sqrt(3)));
    }

    public static float getUpperThreshold(float sigma, float lineWidth, float h) {
        //according to (12) in paper, lineWidth = 2*w
        //r''(x=0,sigma,w,h) = h*(g'_sigma(w) - g'_sigma(-w))
        return (float)((h * -lineWidth)/(Math.sqrt(2*Math.PI)*Math.pow(sigma, 3))*Math.exp(lineWidth*lineWidth/(-8*sigma*sigma)));
    }

    /**
     * perform bimodal run length coding and adaptive thresholding in one step
     */
    private Map<Boolean, Map<Integer, Integer>> adaptiveColumnMajorRLE(Mat mat, int kernelSize, float threshold, int columnStepSize) {
        Mat mean = new Mat();
        Imgproc.GaussianBlur(mat, mean, new Size(kernelSize, kernelSize), kernelSize/6f);
        Map<Boolean, Map<Integer, Integer>> histogram = new HashMap<>();
        histogram.put(true, new HashMap<>());
        histogram.put(false, new HashMap<>());
        int runLength;
        boolean white;
        int depth;

        int runningWhite = 0;
        int runningBlack = 0;
        int whiteCount = 0;
        int blackCount = 0;

        //iterate over mat (for performance reasons, only consider every columnStepSize column)
        for (int col=0; col<mat.cols(); col+=columnStepSize) {
            for (int row=0; row<mat.rows(); row++) {
                runLength = 1;
                white = mat.get(row, col)[0] > mean.get(row, col)[0] - threshold;  //true=white, false = black
                if (white) {
                    whiteCount++;
                    runningWhite += mat.get(row, col)[0];
                }
                else {
                    blackCount++;
                    runningBlack += mat.get(row, col)[0];
                }
                while (row+1 < mat.rows() && mat.get(row+1, col)[0] > mean.get(row+1, col)[0] - threshold == white) {
                    runLength++;
                    row++;
                    if (white) {
                        whiteCount++;
                        runningWhite += mat.get(row, col)[0];
                    }
                    else {
                        blackCount++;
                        runningBlack += mat.get(row, col)[0];
                    }
                }
                //increment histogram entry or initialize with 1 if not existing
                depth = 1;
                if (histogram.get(white).containsKey(runLength))
                    depth = histogram.get(white).get(runLength)+1;
                histogram.get(white).put(runLength, depth);
            }
        }
        staffLineContrast = runningWhite/(float)whiteCount - runningBlack/(float)blackCount;
        return histogram;
    }
}