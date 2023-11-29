package net.scoreworks.omr.stages;

import net.scoreworks.omr.utils.LinePoint;
import net.scoreworks.omr.utils.clustering.MeanShift;
import net.scoreworks.omr.utils.clustering.MomentumClustering;
import net.scoreworks.omr.utils.clustering.MomentumClustering.Cluster;
import net.scoreworks.omr.utils.curves.QuadraticCurveModel;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.util.*;

/**
 * Process line points into staff models
 */
public class StaffDetection {
    private static final float C_phi = 400; //angle gain factor
    private static final float T_span = 0.6f;   //min span of page for valid staffs
    private static final float T_n = 0.3f;  //maximal allowed variance in staff points between staff lines
    private static final int N = 15;    //number of staff segments

    private final List<StaffModel> staffs = new ArrayList<>();

    public StaffDetection(Map<Float, LinePoint> points, float iss, int cols, Mat img) {
        MomentumClustering clusterByStaff = new MomentumClustering((c, p) -> {
            float yDiff = c.getMeanY() - p.y;
            float aDiff = (c.getMeanAngle() - p.angle)* C_phi;
            return (float) Math.sqrt(yDiff*yDiff + aDiff*aDiff);
            }, 3.8f*iss, 1.2f, 40, 120);
        for (LinePoint lp : points.values()) {
            clusterByStaff.feed(lp, true);
        }
        clusterByStaff.settle();

        //process into staffs
        for (Cluster cluster : clusterByStaff.getClusters()) {
            if (cluster.getWidth() > cols* T_span) {
                //filter by angle only with tighter criteria
                MomentumClustering clusterByAngle = new MomentumClustering((c, p) -> Math.abs(c.getMeanAngle() - p.angle),
                        0.1f, 0.2f, 10, 40);
                for (LinePoint lp : cluster.getSavedPoints().values()) {
                    clusterByAngle.feed(lp, true);
                }
                clusterByAngle.settle();
                //try processing to staff
                if (!clusterByAngle.getClusters().isEmpty()) {
                    try {
                        staffs.add(new StaffModel(clusterByAngle.getStrongestCluster(), N, iss));
                    } catch (StaffCreationException ignored) {}
                }
            }
        }
        staffs.sort(Comparator.comparingDouble(s -> s.getPosition(2)));
    }

    public List<StaffModel> getStaffs() {
        return staffs;
    }

    public void visualize(Mat img, Scalar color) {
        for (StaffModel staff : staffs) {
            staff.visualize(img, color);
        }
    }

    public static class StaffModel extends QuadraticCurveModel {
        private final float[] positions = new float[5];

        public StaffModel(Cluster cluster, int numSegments, float iss) throws StaffCreationException {
            super(cluster.getSavedPoints(), numSegments, iss);

            //cluster points corrected by staff model to obtain line positions
            float[] data = new float[cluster.getSavedPoints().size()];
            int i = 0;
            for (LinePoint line : cluster.getSavedPoints().values()) {
                data[i] = line.y - heightAt(line.x);
                i++;
            }
            MeanShift meanShift = new MeanShift(data, 1, 0.18f*iss, 1.7f);
            meanShift.fit();
            if (meanShift.getNumberOfClusters() < 5)
                throw new StaffCreationException("Cluster contains lass than 5 parallel lines");

            //retrieve line positions
            MeanShift.Cluster[] staffLines = meanShift.getNStrongestClusters(5);
            for (i = 0; i < 5; i++) {
                positions[i] = staffLines[i].getPosition()[0];
            }
            Arrays.sort(positions);

            //filter non staffs
            if (normalizedStandardDeviation(staffLines) >= T_n)
                throw new StaffCreationException("Amounts of data points in each line are to different to be a staff");
            //points = filterPointsBelongingToStaff(cluster.getSavedPoints().values(), meanShift.getLabels(), staffLines);
        }

        private float normalizedStandardDeviation(MeanShift.Cluster[] clusters) {
            float mean = 0;
            for (MeanShift.Cluster cluster : clusters) {
                mean += cluster.size();
            }
            mean /= clusters.length;
            float variance = 0;
            for (MeanShift.Cluster cluster : clusters) {
                variance += (cluster.size()-mean)*(cluster.size()-mean);
            }
            return (float) (Math.sqrt(variance/clusters.length) / mean);
        }

        private List<LinePoint> filterPointsBelongingToStaff(Collection<LinePoint> points, MeanShift.Cluster[] labels, MeanShift.Cluster[] staffLines) {
            List<LinePoint> staffPoints = new ArrayList<>();
            Set<MeanShift.Cluster> clusterSet = new HashSet<>();
            Collections.addAll(clusterSet, staffLines);
            int i = 0;
            for (LinePoint linePoint : points) {
                if (clusterSet.contains(labels[i])) {
                    staffPoints.add(linePoint);
                }
                i++;
            }
            return staffPoints;
        }

        public float getPosition(int idx) {
            return positions[idx];
        }

        public float staffHeight(float x, int staffLineIndex) {
            return super.heightAt(x) + positions[staffLineIndex];
        }

        public void visualize(Mat img, Scalar color) {
            /*for (float x=startX; x<=getEnd()+1; x+= segmentLength) {
                Imgproc.circle(img, new Point(x, staffHeight(x, 2)), 12, color);
            }*/
            for (int i=0; i<5; i++) {
                visualize(img, color, 2, true, positions[i]);
            }
        }

        /**
         * calculate x coordinate of intersection with a function defined as x = n*y + c
         */
        public float intersectionX(float n, float c, float yMin, float yMax) {
            if (n == 0) {
                return c;
            }

            //calculate segments to check
            float xMin = n*yMin+c;
            float xMax = n*yMax+c;
            if (xMin > xMax) {
                float temp = xMax;
                xMax = xMin;
                xMin = temp;
            }
            int i = Math.min(numSegments-1, Math.max(0, (int)((xMin-startX)/segmentLength)));
            int iEnd = Math.min(numSegments-1, Math.max(1, (int)((xMax-startX)/segmentLength)));

            //calculate intersections and check if valid
            double x;   //relative to segment (0 at segment start)
            for (; i<=iEnd; i++) {
                double radicand = Math.pow(n*coefficients[i][1] - 1, 2) - 4*n*coefficients[i][0]*(n*(heights[i] + positions[2]) + c - (startX+i*segmentLength));
                //calculate the 2 solutions to quadratic equation and check weather in segment or not
                x = (1-n*coefficients[i][1] + Math.sqrt(radicand)) / (2*n*coefficients[i][0]);
                if ((x >= 0 && x <= segmentLength) || (i == 0 && x < 0 && x > xMin-startX) || (i == numSegments-1 && x > segmentLength && x < xMax-startX+numSegments*segmentLength))
                    return (float) x + startX+i*segmentLength;
                x = (1-n*coefficients[i][1] - Math.sqrt(radicand)) / (2*n*coefficients[i][0]);
                if ((x >= 0 && x <= segmentLength) || (i == 0 && x < 0 && x > xMin-startX) || (i == numSegments-1 && x > segmentLength && x < xMax-startX+numSegments*segmentLength))
                    return (float) x + startX+i*segmentLength;
            }
            return 0;
            //throw new RuntimeException("Couldn't find at least one valid intersection");
        }
    }

    private static class StaffCreationException extends Exception {
        public StaffCreationException(String errorMessage) {
            super(errorMessage);
        }
    }
}