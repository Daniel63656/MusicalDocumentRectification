package net.scoreworks.rectification.utils;

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
    public float f1, f2, strength;

    public LinePoint(float x, float y, float slope, float f1, float f2, float strength) {
        this.x = x;
        this.y = y;
        this.slope = slope;
        this.f1 = f1;
        this.f2 = f2;
        this.strength = strength;
        //calculating angle from slope (invariant under directional reversal of tangential eigenvector)
        angle = (float)Math.atan(slope);
    }

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