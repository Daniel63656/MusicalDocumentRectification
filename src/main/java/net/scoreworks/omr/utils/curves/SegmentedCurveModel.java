package net.scoreworks.omr.utils.curves;

import java.util.Map;
import java.util.NavigableMap;

import static net.scoreworks.omr.utils.Utils.linearInterpolation;

/**
 * Base class for all models for a 2d curve
 */
public abstract class SegmentedCurveModel {
    protected static final int ARC_LENGTH_SAMPLES = 80;
    protected NavigableMap<Float, Float> arcLengthParametrization;


    /**
     * @return corresponding x for a given 0<=t<=1 in arc length parametrization. If no parametrization exists yet,
     * generate a table of calculated arc lengths for efficient access. Then x is linearly interpolated between those
     * values. In case of a {@link LinearCurveModel} this is an exact parametrization
     */
    public float arcLengthParametrization(float t) {
        //first query -> create arc length parametrization
        if (arcLengthParametrization == null) {
            createArcLengthParametrization();
        }
        t *= arcLengthParametrization.lastKey();
        Map.Entry<Float, Float> floor  = arcLengthParametrization.floorEntry(t);
        Map.Entry<Float, Float> higher = arcLengthParametrization.higherEntry(t);
        if (floor == null) {
            floor = higher;
            higher = arcLengthParametrization.higherEntry(higher.getKey());
        }
        if (higher == null) {
            higher = floor;
            floor = arcLengthParametrization.lowerEntry(floor.getKey());
        }
        return linearInterpolation(floor.getValue(), higher.getValue(), floor.getKey(), higher.getKey(), t);
    }

    public abstract void createArcLengthParametrization();

    /**
     * @return arc length of the curve between a and b
     */
    public abstract float arcLength(float a, float b);
}
