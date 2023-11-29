package net.scoreworks.omr.rectification.utils.curves;

import net.scoreworks.omr.rectification.utils.LinePoint;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.SortedMap;

public class LinearCurveModel extends RegularCurveModel {
    protected final float[] heights;

    public LinearCurveModel(float startX, int numSegments, float segmentLength, float[] heights) {
        super(startX, numSegments, segmentLength);
        this.heights = heights;
    }

    //no drift correction
    public LinearCurveModel(SortedMap<Float, LinePoint> points, int numSegments) {
        super(points.firstKey(), numSegments, (points.lastKey() - points.firstKey()) / numSegments);
        heights = new float[numSegments+1];

        //create rough staff model by average slopes
        for (int i=0; i<numSegments; i++) {
            float slope = averageSlope(points.subMap(startX+(i*segmentLength), startX+(i+1f)*segmentLength));
            heights[i+1] = heights[i]+slope*segmentLength;
        }
    }

    public LinearCurveModel(SortedMap<Float, LinePoint> points, int numSegments, float divisor) {
        super(points.firstKey(), numSegments, (points.lastKey() - points.firstKey()) / numSegments);
        heights = new float[numSegments+1];

        //create rough staff model by average slopes
        for (int i=0; i<numSegments; i++) {
            float slope = averageSlope(points.subMap(startX+(i*segmentLength), startX+(i+1f)*segmentLength));
            heights[i+1] = heights[i]+slope*segmentLength;
            //in first iteration use meanHeight to set first height
            if (i == 0) {
                heights[i] = meanCircularHeight(points, startX, 0, divisor);
            }
            //calculate drift within segment and correct by changing end height
            heights[i+1] += meanCircularHeight(points, startX + (i+1)*segmentLength, i, divisor);
        }
    }

    public static float averageSlope(SortedMap<Float, LinePoint> points) {
        float slope = 0;
        for (LinePoint line : points.values()) {
            slope += line.slope;
        }
        return slope/points.size();
    }

    @Override
    public float heightAt(float x) {
        return heightAt(x, Math.max(0, Math.min(numSegments-2, (int) ((x-startX)/segmentLength))));
    }

    @Override
    protected float heightAt(float x, int idx) {
        idx = Math.min(idx, numSegments-2);
        return heights[idx] + (x-(startX+idx*segmentLength))*slopeAt(x, idx);
    }

    public float slopeAt(float x) {
        return slopeAt(x, Math.max(0, Math.min(numSegments-2, (int) ((x-startX)/segmentLength))));
    }

    public float slopeAt(float x, int idx) {
        return (heights[idx+1] - heights[idx])/segmentLength;
    }

    @Override
    protected float arcLengthAntiderivative(int i, float x) {
        float slope = slopeAt(x, i);
        return (float) (Math.sqrt(1 +slope*slope) * x);
    }

    @Override
    public void visualize(Mat img, Scalar color, int thickness, boolean horizontal) {
        visualize(img, color, thickness, horizontal, 0f);
    }
    @Override
    public void visualize(Mat img, Scalar color, int thickness, boolean horizontal, float heightDisplacement) {
        float x = startX;
        if (horizontal) {
            for (int i=0; i<numSegments; i++) {
                Imgproc.line(img, new Point(x, heightDisplacement + heightAt(x)),
                        new Point(x + segmentLength, heightDisplacement + heightAt(x + segmentLength)), color, thickness);
                x += segmentLength;
            }
        }
        else {
            for (int i=0; i<numSegments; i++) {
                Imgproc.line(img, new Point(heightDisplacement + heightAt(x), x),
                        new Point(heightDisplacement + heightAt(x + segmentLength), x + segmentLength), color, thickness);
                x += segmentLength;
            }
        }
    }
}