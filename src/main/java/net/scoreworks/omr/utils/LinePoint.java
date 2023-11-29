package net.scoreworks.omr.utils;

import org.opencv.core.Mat;

/**
 * A class to represent a point of a curvilinear structure, consisting of its
 * coordinates, slope and strength (confidence value)
 */
public class LinePoint {
    public float x;
    public float y;
    public float slope;
    public float angle;

    public LinePoint(float x, float y, float slope) {
        this.x = x;
        this.y = y;
        this.slope = slope;
        //calculating angle from slope (invariant under directional reversal of tangential eigenvector)
        angle = (float)Math.atan(slope);
    }

    public LinePoint(float x, float y, float tx, float ty) {
        this.x = x;
        this.y = y;
        this.slope = ty/tx;
        //calculate angle [-PI, PI] respecting tangential direction in full circle
        angle = (float)Math.atan2(ty, tx);
    }

    public void visualize(Mat img, double[] color) {
        img.put((int) y, (int) x, color);
    }
}