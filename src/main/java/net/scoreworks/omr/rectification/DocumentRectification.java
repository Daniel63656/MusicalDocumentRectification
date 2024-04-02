package net.scoreworks.omr.rectification;

import net.scoreworks.omr.rectification.stages.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static net.scoreworks.omr.rectification.utils.LightingCorrection.betterGrayscaleAdaptiveThresholding;
import static net.scoreworks.omr.rectification.utils.Utils.nearestOddNumber;

/**
 * Main class for the rectification pipeline.
 * Using openCV requires it being specified in class' run configuration. To do so follow these steps:
 *  - right click on class > More Run/Debug > Modify Run Configurations > alt + V
 *  - write "-Djava.library.path=openCV" in the field
 */
public class DocumentRectification {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
    private final Mat img, rectified;
    private final List<Long> timestamps = new ArrayList<>();


    public static void main(String[] args) {
        //test on dataset
        File src = new File("src/main/resources/dataset");
        String dst = "output/";
        for (File file : src.listFiles()) {
            System.out.println("Doing file "+file.getName());
            DocumentRectification rect = new DocumentRectification(Imgcodecs.imread(file.toString(), Imgcodecs.IMREAD_COLOR));
            Core.bitwise_not(rect.rectified, rect.rectified); //convert back to "normal" contrast
            Imgcodecs.imwrite(dst+file.getName(), rect.rectified);
            Imgcodecs.imwrite(dst+"staffDetection/"+file.getName(), rect.img);
        }

        //test with a single file
        /*DocumentRectification rect = new DocumentRectification(Imgcodecs.imread("src/main/resources/test.jpg", Imgcodecs.IMREAD_COLOR));
        Imgcodecs.imwrite("out.jpg", rect.img);
        Core.bitwise_not(rect.rectified, rect.rectified); //convert back to "normal" contrast
        Imgcodecs.imwrite("transformed.jpg", rect.rectified);*/
    }


    /**
     * Instantiate a rectification process on the given image
     */
    public DocumentRectification(Mat img) {
        this.img = img;
        Mat grayscale = new Mat();
        Imgproc.cvtColor(img, grayscale, Imgproc.COLOR_BGR2GRAY);   //CV_8U
        Core.bitwise_not(grayscale, grayscale); //make features white on black background to follow the usual convention

        //create LineModel
        timestamps.add(System.currentTimeMillis());
        LineModel lineModel = new LineModel(grayscale);
        float iss = lineModel.getInterlineStaffSpace();
        timestamps.add(System.currentTimeMillis());

        // Do lighting correction parallel to geometric rectification once iss known
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Mat> correctLighting = executor.submit(() -> betterGrayscaleAdaptiveThresholding(grayscale,
                nearestOddNumber(0.75*iss), nearestOddNumber(2.5*iss), 15, 60));

        //detect curvilinear points
        float sigma = 3f*LineModel.getLowerSigma(lineModel.getStaffLineThickness());
        float threshold = 0.4f * LineModel.getUpperThreshold(sigma, lineModel.getStaffLineThickness(), lineModel.getStaffLineContrast());
        StegerPointDetection stegerPointDetection = new StegerPointDetection(grayscale, sigma);
        timestamps.add(System.currentTimeMillis());

        //detect staffs
        StaffDetection staffDetection = new StaffDetection(stegerPointDetection.getHorizontalPoints(threshold), iss, img.cols());
        timestamps.add(System.currentTimeMillis());

        //detect longitudes
        LongitudeDetection ld = new LongitudeDetection(staffDetection.getStaffs(),
                stegerPointDetection.getVerticalPoints(threshold),
                iss, img.rows(), img.cols());
        timestamps.add(System.currentTimeMillis());

        //reconstruct 3D surface
        SurfaceReconstruction reconstruction = new SurfaceReconstruction(ld.getMeshPoints(), ld.getMeshPoints().size(),
                staffDetection.getStaffs().size(), img.rows(), img.cols());
        timestamps.add(System.currentTimeMillis());

        // await result of lighting correction to do geometric rectification on
        Mat normalized = null;
        try {
            normalized = correctLighting.get(); // This blocks until 'taskFoo' is finished
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions that may occur during 'taskFoo'
        }
        executor.shutdown();

        //rectify the image
        rectified = new Rectification(normalized, staffDetection.getStaffs(), reconstruction, iss, img.rows(), img.cols()).getRectifiedImage();
        timestamps.add(System.currentTimeMillis());

        //print results from stages onto images for debugging/visualizations
        stegerPointDetection.visualize(img, threshold, threshold, new Scalar(0,255,0), new Scalar(255, 0, 0), 2);
        //staffDetection.visualize(img, new Scalar(0, 0, 255));
        //ld.visualize(img, new Scalar(255, 0, 0));

        printProcessTimes();
    }

    private void printProcessTimes() {
        int total = (int) (timestamps.get(timestamps.size()-1) - timestamps.get(0));
        System.out.println("Detection took "+(total/1000f)+"s");

        for (int i=1; i<timestamps.size(); i++)
            System.out.printf(" >Step %d: %.2f%%%n", i, (timestamps.get(i) - timestamps.get(i - 1)) * 100f / total);
        System.out.print("\n");
    }
}