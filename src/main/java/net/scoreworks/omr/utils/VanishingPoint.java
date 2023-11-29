package net.scoreworks.omr.utils;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * A simple class representing a vanishing point in homogeneous coordinates
 */
public class VanishingPoint {
    private final float[] coordinates;

    public VanishingPoint(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public VanishingPoint(Collection<LinePoint> linePoints, boolean horizontal) {
        Mat A = new Mat(linePoints.size(), 3, CvType.CV_32F);
        if (!horizontal) {
            double n, c;
            int i = 0;
            for (LinePoint lp : linePoints) {
                n = lp.slope;
                c = lp.x - lp.slope * lp.y;
                A.put(i, 0, -1, n, c);
                i++;
            }
        }
        else {
            double m, b;
            int i = 0;
            for (LinePoint lp : linePoints) {
                m = lp.slope;
                b = lp.y - lp.slope * lp.x;
                A.put(i, 0, m, -1, b);
                i++;
            }
        }

        //perform singular value decomposition (SVD) on matrix A
        Mat vt = new Mat();
        Core.SVDecomp(A, new Mat(), new Mat(), vt);

        //null space solution (least squares solution)
        coordinates = new float[3];
        vt.row(vt.rows() - 1).t().get(0, 0, coordinates);
    }

    public boolean isAtInfinity() {
        return  coordinates[2] == 0;
    }

    public float getEuclideanX() {
        return coordinates[0]/coordinates[2];
    }

    public float getEuclideanY() {
        return coordinates[1]/coordinates[2];
    }

    public Point toEuclideanCoordinates() {
        return new Point(getEuclideanX(), getEuclideanY());
    }

    public float[] getHomogeneousCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        if (isAtInfinity())
            return "(INFINITY)";
        else return String.format(Locale.US,"(%.4f|%.4f)\n", getEuclideanX(), getEuclideanY());
    }
}
