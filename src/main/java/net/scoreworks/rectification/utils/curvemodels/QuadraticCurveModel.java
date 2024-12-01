package net.scoreworks.rectification.utils.curvemodels;

import java.lang.Math;

import net.scoreworks.rectification.utils.LinePoint;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.Collection;
import java.util.SortedMap;

/**
 * Quadratic version of the regular curve model. The model is unclamped, meaning that beyond the curve boundaries, the
 * model is continued linearly if queried.
 */
public class QuadraticCurveModel extends RegularCurveModel {

    //piecewise quadratic function axx + bx + c, represented as coefficients at start of a segment: [segment][2a, b, c]
    protected final float[][] coefficients;
    protected final float[] heights;

    public QuadraticCurveModel(SortedMap<Float, LinePoint> points, int numSegments) {
        super(points.firstKey(), numSegments, (points.lastKey() - points.firstKey()) / numSegments);
        coefficients = new float[numSegments][2];
        heights = new float[numSegments+1];

        for (int i=0; i<numSegments; i++) {
            float[] statistics = linearRegressionOnSlope(points.subMap(startX+(i*segmentLength), startX+(i+1)*segmentLength).values());
            coefficients[i][0] = 0.5f*statistics[0];
            coefficients[i][1] = statistics[0]*(startX+i*segmentLength) + statistics[1];

            //calculate height for next segment to be smooth
            heights[i+1] = heightAt(startX+(i+1)*segmentLength, i);
        }
    }

    public QuadraticCurveModel(SortedMap<Float, LinePoint> points, int numSegments, float divisor) {
        super(points.firstKey(), numSegments, (points.lastKey() - points.firstKey()) / numSegments);
        coefficients = new float[numSegments][2];
        heights = new float[numSegments+1];

        for (int i=0; i<numSegments; i++) {
            float[] statistics = linearRegressionOnSlope(points.subMap(startX+(i*segmentLength), startX+(i+1)*segmentLength).values());
            coefficients[i][0] = 0.5f*statistics[0];
            coefficients[i][1] = statistics[0]*(startX+i*segmentLength) + statistics[1];

            //in first iteration use meanHeight to set first height
            if (i == 0) {
                heights[0] = meanCircularHeight(points, startX, 0, divisor);
            }
            //find drift with circular mean (iss being one full circle revolution)
            //correct drift by changing b: axx + bx + c + drift = axx + Bx + c
            coefficients[i][1] += meanCircularHeight(points, startX + (i+1)*segmentLength, i, divisor) / segmentLength;

            //calculate height for next segment to be smooth
            heights[i+1] = heightAt(startX+(i+1)*segmentLength, i);
        }
    }

    private static float[] linearRegressionOnSlope(Collection<LinePoint> points) {
        int n = points.size();
        //calculate mean
        float meanX = 0, meanY = 0;

        for (LinePoint lp : points) {
            meanX += lp.x;
            meanY += lp.slope;
        }
        meanX /= n;
        meanY /= n;
        //calculate covariance and variances
        float covariance = 0, varX = 0, varY = 0;
        for (LinePoint lp : points) {
            covariance += (lp.x - meanX) * (lp.slope - meanY);
            varX += (lp.x - meanX) * (lp.x - meanX);
            varY += (lp.slope - meanY) * (lp.slope - meanY);
        }
        //calculate statistical data
        float correlation = (float) (covariance/Math.sqrt(varX*varY));
        float slope  = covariance / varX;
        float intercept = meanY - slope * meanX;
        return new float[]{slope, intercept, correlation*correlation};
    }

    public float heightAt(float x) {
        int idx = (int) ((x-startX)/segmentLength);
        //provide unclamped (linear) continuation outside of model
        if (x < startX)
            return heights[0] + (heights[1]-heights[0]) / segmentLength*(x - startX);
        else if (idx >= numSegments)
            return heights[numSegments] + (heights[numSegments]-heights[numSegments-1]) / segmentLength*(x - getEnd());
        //otherwise use model itself
        return heightAt(x, idx);
    }

    protected float heightAt(float x, int idx) {
        x -= (startX+idx*segmentLength);
        return coefficients[idx][0]*x*x + coefficients[idx][1]*x + heights[idx];
    }

    public float slopeAt(float x) {
        int idx = (int) ((x-startX)/segmentLength);
        //provide unclamped (linear) continuation outside of model
        if (x < startX)
            return (heights[1]-heights[0])/segmentLength;
        else if (idx >= numSegments)
            return (heights[numSegments]-heights[numSegments-1])/segmentLength;
        //otherwise use model itself
        return slopeAt(x, Math.max(0, idx));
    }

    public float slopeAt(float x, int idx) {
        x -= (startX+idx*segmentLength);
        return 2*coefficients[idx][0]*x + coefficients[idx][1];
    }

    @Override
    protected float arcLengthAntiderivative(int i, float x) {
        float temp = 2*coefficients[i][0]*x + coefficients[i][1];
        float temp2 = (float) Math.sqrt(1 + temp*temp);
        return (float) ((coefficients[i][1]*temp2 + Math.log(temp2 + temp))/(4*coefficients[i][0]) + x*temp2/2);
    }

    @Override
    public void visualize(Mat img, Scalar color, int thickness, boolean horizontal) {
        visualize(img, color, thickness, horizontal, 0f);
    }
    @Override
    public void visualize(Mat img, Scalar color, int thickness, boolean horizontal, float heightDisplacement) {
        int len = 8;
        float x = startX;
        float endX = startX+numSegments*segmentLength;
        if (horizontal) {
            for (;; x+=len) {
                if (x+len < endX) {
                    Imgproc.line(img, new Point(x, heightDisplacement + heightAt(x)),
                            new Point(x + len, heightDisplacement + heightAt(x + len)), color, thickness);
                }
                else {
                    Imgproc.line(img, new Point(x, heightDisplacement + heightAt(x)),
                            new Point(endX, heightDisplacement + heightAt(x + len)), color, thickness);
                    break;
                }
            }
        }
        else {
            for (;; x+=len) {
                if (x+len < endX) {
                    Imgproc.line(img, new Point(heightDisplacement + heightAt(x), x),
                            new Point(heightDisplacement + heightAt(x + len), x + len), color, thickness);
                }
                else {
                    Imgproc.line(img, new Point(x, heightDisplacement + heightAt(x)),
                            new Point(endX, heightDisplacement + heightAt(x + len)), color, thickness);
                    break;
                }
            }
        }
    }
}