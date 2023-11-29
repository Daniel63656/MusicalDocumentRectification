package net.scoreworks.omr;

import org.junit.jupiter.api.Test;
import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;

public class EigenvalueDecompositionTests {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
    @Test
    public void testInverse() {
        File src = new File("src/main/resources/dataset");
        String dst = "output/";
        for (File file : src.listFiles()) {
            System.out.println("Doing file "+file.getName());
            DocumentRectification rect = new DocumentRectification(Imgcodecs.imread(file.toString(), Imgcodecs.IMREAD_COLOR));
            Core.bitwise_not(rect.rectified, rect.rectified); //convert back to "normal" contrast
            Imgcodecs.imwrite(dst+file.getName(), rect.rectified);
            Imgcodecs.imwrite(dst+"staffDetection/"+file.getName(), rect.img);
        }
    }
}