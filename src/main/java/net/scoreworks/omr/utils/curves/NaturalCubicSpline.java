package net.scoreworks.omr.utils.curves;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.opencv.core.Point;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * A natural (also known as "free", "unclamped") cubic spline based on apaches {@link org.apache.commons.math3.analysis.interpolation.SplineInterpolator} and
 * {@link org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction}
 */
public class NaturalCubicSpline extends SegmentedCurveModel {

    /**
     * number of spline segments. It is equal to the number of polynomials and
     * to the number of partition points - 1.
     */
    private final int numSegments;

    /**
     * save the {@link NaturalCubicSpline#numSegments}+1 control points of the spline
     */
    public final Point[] controlPoints;

    /**
     * coefficients of a spline keyed to its start value for efficient access. A spline has the coefficients [a, b, c, y]: a*x^3 + b*x^2 + c*x + y
     */
    private final NavigableMap<Double, double[]> polynomials = new TreeMap<>();

    public NaturalCubicSpline(double[] x, double[] y) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException {
        if (x.length != y.length) {
            throw new DimensionMismatchException(x.length, y.length);
        }
        if (x.length < 3) {
            throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, x.length, 3, true);
        }
        numSegments = x.length - 1;
        controlPoints = new Point[numSegments+1];
        MathArrays.checkOrder(x);

        // Differences between knot points
        final double[] h = new double[numSegments];
        for (int i=0; i<numSegments; i++) {
            h[i] = x[i + 1] - x[i];
            controlPoints[i] = new Point(x[i], y[i]);
        }
        controlPoints[numSegments] = new Point(x[numSegments], y[numSegments]);

        final double[] mu = new double[numSegments];
        final double[] z = new double[numSegments + 1];
        mu[0] = 0d;
        z[0] = 0d;
        double g;
        for (int i=1; i<numSegments; i++) {
            g = 2d * (x[i+1]  - x[i - 1]) - h[i - 1] * mu[i -1];
            mu[i] = h[i] / g;
            z[i] = (3d * (y[i + 1] * h[i - 1] - y[i] * (x[i + 1] - x[i - 1])+ y[i - 1] * h[i]) / (h[i - 1] * h[i]) - h[i - 1] * z[i - 1]) / g;
        }

        final double[] a = new double[numSegments];
        final double[] b = new double[numSegments + 1];
        final double[] c = new double[numSegments];
        z[numSegments] = 0d;
        b[numSegments] = 0d;
        for (int j=numSegments-1; j>=0; j--) {
            b[j] = z[j] - mu[j] * b[j + 1];
            c[j] = (y[j + 1] - y[j]) / h[j] - h[j] * (b[j + 1] + 2d * b[j]) / 3d;
            a[j] = (b[j + 1] - b[j]) / (3d * h[j]);
        }
        for (int i=0; i<numSegments; i++) {
            double[] coefficients = new double[4];
            coefficients[0] = a[i];
            coefficients[1] = b[i];
            coefficients[2] = c[i];
            coefficients[3] = y[i];
            polynomials.put(x[i], coefficients);
        }
    }

    public double value(double x) {
        if (x < controlPoints[0].x) {
            double slope = polynomials.firstEntry().getValue()[2];
            return slope*(x-controlPoints[0].x) + controlPoints[0].y;
        }
        else if (x > controlPoints[numSegments].x) {
            double slope = polynomials.lastEntry().getValue()[2];
            return slope*(x-controlPoints[numSegments].x) + controlPoints[numSegments].y;
        }
        else {
            return evaluatePolynomial(polynomials.get(polynomials.floorKey(x)), x - polynomials.floorKey(x));
        }
    }

    /**
     * evaluate polynomial using Horner's method
     */
    private double evaluatePolynomial(double[] coefficients, double argument) {
        double result = coefficients[0];
        for (int i=1; i<4; i++)
            result = result*argument + coefficients[i];
        return result;
    }

    @Override
    public void createArcLengthParametrization() {

    }

    @Override
    public float arcLength(float a, float b) {
        return 0;
    }
}