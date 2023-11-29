package net.scoreworks.omr.utils.curves;

import net.scoreworks.omr.utils.LinePoint;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.util.*;

import static net.scoreworks.omr.utils.Utils.median;

/**
 * A curve modelled by a number of regular spaced segments
 */
public abstract class RegularCurveModel extends SegmentedCurveModel {
    protected static final float SEG = 0.25f;
    protected final float startX;
    protected final int numSegments;
    protected final float segmentLength;

    protected RegularCurveModel(float startX, int numSegments, float segmentLength) {
        this.startX = startX;
        this.numSegments = numSegments;
        this.segmentLength = segmentLength;
    }

    /**
     * retrieve curve height for a given x. The segment used for interpolation is automatically
     * calculated from x
     */
    public abstract float heightAt(float x);

    /**
     * retrieve curve height for a given x and a specified segment
     */
    protected abstract float heightAt(float x, int idx);

    /**
     * retrieve curve slope for a given x. The segment used for interpolation is automatically
     * calculated from x
     */
    public abstract float slopeAt(float x);

    /**
     * retrieve curve slope for a given x and a specified segment
     */
    protected abstract float slopeAt(float x, int idx);

    @Override
    public void createArcLengthParametrization() {
        arcLengthParametrization = new TreeMap<>();
        float h = (getEnd() - getStart()) / ARC_LENGTH_SAMPLES;
        float t = 0;
        arcLengthParametrization.put(t, startX);
        for (int i=1; i<=ARC_LENGTH_SAMPLES; i++) {
            t += arcLength(startX+(i-1)*h, startX+i*h);
            arcLengthParametrization.put(t, startX+i*h);
        }
    }

    @Override
    public float arcLength(float a, float b) {
        //loop over affected segments
        int iEnd = Math.min(numSegments, (int) ((b-startX)/segmentLength)+1);
        float res = 0;
        for (int i=Math.max(0, (int) ((a-startX)/segmentLength)); i<iEnd; i++) {
            res += arcLengthAntiderivative(i, Math.min(segmentLength, b-(startX+i*segmentLength))) - arcLengthAntiderivative(i, Math.max(0, a-(startX+i*segmentLength)));
        }
        return res;
    }

    protected abstract float arcLengthAntiderivative(int segment, float x);

    public abstract void visualize(Mat img, Scalar color, int thickness, boolean horizontal);
    public abstract void visualize(Mat img, Scalar color, int thickness, boolean horizontal, float heightDisplacement);

    public float getStart() {
        return startX;
    }

    public float getEnd() {
        return startX + numSegments*segmentLength;
    }

    public float getSegmentLength() {
        return segmentLength;
    }


    //----------drift correction----------

    protected float meanHeight(SortedMap<Float, LinePoint> points, float location, int segment) {
        float aggregate = 0;
        int count =0;
        for (LinePoint line : points.subMap(location - SEG*segmentLength, location + SEG*segmentLength).values()) {
            aggregate += line.y - heightAt(line.x, segment);
            count++;
        }
        return aggregate/count;
    }

    protected float meanCircularHeight(SortedMap<Float, LinePoint> points, float location, int segment, float divisor) {
        List<Float> drift = new ArrayList<>();
        float phase;
        for (LinePoint lp : points.subMap(location - SEG*segmentLength, location + SEG*segmentLength).values()) {
            phase = (lp.y - heightAt(lp.x, segment)) % divisor;
            if (phase > divisor/2)
                phase -= divisor;
            drift.add(phase);
        }
        return median(drift);
    }
}