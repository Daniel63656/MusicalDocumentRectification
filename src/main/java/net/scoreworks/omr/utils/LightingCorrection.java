package net.scoreworks.omr.utils;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public final class LightingCorrection {
    //make instantiation impossible
    private LightingCorrection() {}

    public static Mat betterGrayscaleAdaptiveThresholding(Mat src, int kernelSizeMorph, int kernelSizeBlur, float C_bg, float C_fg) {
        Mat dst = new Mat();
        src.copyTo(dst);
        Mat mean = new Mat();

        //remove noise
        Imgproc.GaussianBlur(dst, mean, new Size(5, 5), 2.4);
        //optimally, no foreground should be present when blurring to get the threshold texture. Dilation makes the
        //background override a lot of foreground, leading to much better results
        Imgproc.morphologyEx(mean, mean, Imgproc.MORPH_ERODE, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(kernelSizeMorph, kernelSizeMorph)));
        //finally, blur the image to get a mean
        Imgproc.GaussianBlur(mean, mean, new Size(kernelSizeBlur, kernelSizeBlur), 0);

        //loop over image and map intensities
        float m, b;
        int srcValue, meanValue;
        byte[] srcData = new byte[(int)src.total()];
        src.get(0, 0, srcData);
        byte[] meanData = new byte[(int)mean.total()];
        mean.get(0, 0, meanData);
        for (int x=0; x<dst.cols(); x++) {
            for (int y=0; y<dst.rows(); y++) {
                //convert unsigned byte to int for calculations
                srcValue = ((int) srcData[x + y*src.cols()]) & 0xFF;
                meanValue = ((int) meanData[x + y*src.cols()]) & 0xFF;
                // linear intensity mapping function through (meanValue+C_bg|0), (meanValue+C_fg|255)
                m = 255f/((meanValue+C_fg) - (meanValue+C_bg));
                b = -m*(meanValue+C_bg);
                srcData[x + y*src.cols()] = (byte) Math.min(255, Math.max(0, srcValue*m + b));
            }
        }
        dst.put(0, 0, srcData);
        return dst;
    }
}