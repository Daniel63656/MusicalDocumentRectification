package net.scoreworks.omr.rectification.stages;

import net.scoreworks.omr.rectification.utils.LinePoint;
import net.scoreworks.omr.rectification.utils.clustering.MeanShift;
import net.scoreworks.omr.rectification.utils.clustering.MomentumClustering;
import net.scoreworks.omr.rectification.utils.clustering.MomentumClustering.Cluster;
import net.scoreworks.omr.rectification.utils.curves.QuadraticCurveModel;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.*;

import static net.scoreworks.omr.rectification.utils.Utils.getColor;

/**
 * Process line points into staff models
 */
public class StemDetection {
    private static final float C_phi = 50; //angle gain factor
    private final List<Cluster> lines = new ArrayList<>();

    public StemDetection(List<LinePoint> points, float iss) {
        MomentumClustering clustering = new MomentumClustering((c, p) -> {
            float yDiff = c.getMeanY() - p.y;
            float aDiff = (c.getMeanAngle() - p.angle)*C_phi;
            return (float) Math.sqrt(yDiff*yDiff + aDiff*aDiff);
            }, 0.3f*iss, 0.8f, (int)(2*iss), 10);
        for (LinePoint lp : points) {
            clustering.feed(lp, true);
        }
        clustering.settle();

        for (Cluster c : clustering.getClusters()) {
            if (c.size() > 20)
                lines.add(c);
        }
    }

    public void visualize(Mat img) {
        for (int i=0; i<lines.size(); i++) {
            Scalar color = getColor(i);
            for (LinePoint lp : lines.get(i).getSavedPoints().values()) {
                Imgproc.circle(img, new Point(lp.y, lp.x), 2, color);
            }
        }
    }
}