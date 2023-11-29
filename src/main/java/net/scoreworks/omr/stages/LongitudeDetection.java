package net.scoreworks.omr.stages;

import net.scoreworks.omr.stages.StaffDetection.StaffModel;
import net.scoreworks.omr.utils.LinePoint;
import net.scoreworks.omr.utils.clustering.MomentumClustering;
import net.scoreworks.omr.utils.clustering.MomentumClustering.Cluster;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.*;

/**
 * Detect longitudes in the document (vertical lines)
 */
public class LongitudeDetection {
    private static final int K = 50;    //number of points for control point averaging
    private final float EPSILON = 9;    //smoothing parameter for gaussian kernel function
    private static final float C_l = 4; //spacing between longitudes in multiple of iss

    private final List<StaffModel> staffs;
    private final NavigableMap<Float, LinePoint> controlPoints = new TreeMap<>();
    private final List<Point[]> meshPoints = new ArrayList<>();


    public LongitudeDetection(List<StaffModel> staffs, List<LinePoint> verticalPoints, float iss, int rows, int cols) {
        this.staffs = staffs;

        //cluster points by dominant vertical direction and staff
        Map<StaffModel, MomentumClustering> staffClustering = new HashMap<>();
        for (StaffModel staff : staffs) {
            staffClustering.put(staff, new MomentumClustering((c, p) -> Math.abs(c.getMeanAngle() - p.angle), 0.05f, 0, 100, 25));
        }

        StaffModel nearest;
        for (LinePoint lp : verticalPoints) {
            nearest = staffs.get(getNearestStaffIdx(lp.x, lp.y));
            //only consider point if on staff
            if (lp.x > nearest.getStart() - iss && lp.x < nearest.getEnd() + iss
                    && lp.y < nearest.staffHeight(lp.x, 4) + 5*iss
                    && lp.y > nearest.staffHeight(lp.x, 0) - 5*iss)
                staffClustering.get(nearest).feed(lp, true);
        }
        //settle and get points of the highest cluster
        ArrayList<Cluster> clusters = new ArrayList<>();
        for (StaffModel staff : staffs) {
            staffClustering.get(staff).settle();
            clusters.add(staffClustering.get(staff).getStrongestCluster());
        }

        //process into a few points sampled along the staff
        createControlPoints(clusters);

        //create mesh points in regular intervals
        float space = C_l*iss;
        createMesh(cols/2f, EPSILON*iss, space, false, rows);         //from middle to begin of image
        createMesh(cols/2f+space, EPSILON*iss, space, true, rows);    //from middle+space to end of image
    }

    public List<Point[]> getMeshPoints() {
        return meshPoints;
    }

    private int getBottomStaffIdx(float x, float y) {
        int i;
        for(i=0; i<this.staffs.size(); ++i) {
            StaffModel staff = staffs.get(i);
            if (y - staff.staffHeight(x, 2) < 0) {
                return i;
            }
        }
        return i - 1;
    }

    private int getNearestStaffIdx(float x, float y) {
        int idx = Math.max(1, getBottomStaffIdx(x, y));
        if (Math.abs(staffs.get(idx).staffHeight(x, 2)-y) < Math.abs(staffs.get(idx-1).staffHeight(x, 2)-y))
            return idx;
        return idx - 1;
    }

    private void createControlPoints(ArrayList<Cluster> clusters) {
        for (int i=0; i<clusters.size(); i++) {
            Iterator<LinePoint> itr = clusters.get(i).getSavedPoints().values().iterator();
            List<LinePoint> temp = new ArrayList<>();
            LinePoint lp;
            float aggregateX = 0;
            float aggregateSlope = 0;

            while(itr.hasNext()) {
                lp = itr.next();
                aggregateX += lp.x;
                aggregateSlope += lp.slope;
                temp.add(lp);
                if (temp.size() >= K) {
                    float x = aggregateX/temp.size();
                    float y = staffs.get(i).staffHeight(x, 2);
                    controlPoints.put(x, new LinePoint(x, y, aggregateSlope/temp.size()));

                    //remove first n/2 entries
                    while(temp.size() > K /2) {
                        aggregateX -= temp.get(0).x;
                        aggregateSlope -= temp.get(0).slope;
                        temp.remove(0);
                    }
                }
            }
            float x = aggregateX/temp.size();
            float y = staffs.get(i).staffHeight(x, 2);
            controlPoints.put(x, new LinePoint(x, y, aggregateSlope/temp.size()));
        }
    }

    private double slopeAt(float x, float y, float smoothness) {
        double sum = 0, weightSum = 0;
        double weight;
        for (LinePoint lp : controlPoints.subMap(x-3*smoothness, x+3*smoothness).values()) {
            weight = Math.exp(-((x-lp.x)*(x-lp.x) + (y-lp.y)*(y-lp.y))/(2*smoothness*smoothness));
            sum += weight*lp.slope;
            weightSum += weight;
        }
        return sum / weightSum;
    }

    private void createMesh(float startX, float smoothness, float space, boolean increasingDirection, int rows) {
        int increment = increasingDirection ? 1 : -1;
        for (float X = startX;; X += increment * space) {
            boolean end = true;
            float x = X;
            float y = staffs.get(0).staffHeight(x, 2);
            float n, c, spX, spY;
            Point[] intersections = new Point[staffs.size()];
            intersections[0] = new Point(x, y);

            for(int j=0; j<staffs.size()-1; ++j) {
                n = (float) slopeAt(x, (staffs.get(j).staffHeight(x, 2) + staffs.get(j+1).staffHeight(x, 2)) / 2, smoothness);
                c = x - n * y;
                spX = staffs.get(j + 1).intersectionX(n, c, 0, rows);
                spY = staffs.get(j + 1).staffHeight(spX, 2);
                intersections[j+1] = new Point(spX, spY);
                //Imgproc.circle(img, new Point(spX, spY), 9, new Scalar(255, 0, 0), 4);
                //Imgproc.line(img, new Point(x, y), new Point(spX, spY), new Scalar(255, 0, 0), 2);
                x = spX;
                y = spY;
                if (increasingDirection) {
                    if (spX <= staffs.get(j + 1).getEnd() - space)
                        end = false;
                }
                else {
                    if (spX >= staffs.get(j + 1).getStart() + space)
                        end = false;
                }
            }
            if (increasingDirection)
                meshPoints.add(intersections);
            else
                meshPoints.add(0, intersections);
            if (end)
                break;
        }
    }

    public void visualize(Mat img, Scalar color) {
        for (Point[] meshPoint : meshPoints) {
            for (int j = 0; j < staffs.size() - 1; j++) {
                Imgproc.line(img, new Point(meshPoint[j].x, meshPoint[j].y), new Point(meshPoint[j + 1].x, meshPoint[j + 1].y), color, 2);
            }
        }

        Scalar c = new Scalar(0, 100, 255);
        for (LinePoint lp : controlPoints.values()) {
            Imgproc.circle(img, new Point(lp.x, lp.y), 20, c, 2);
            Imgproc.line(img, new Point(lp.x - 30 * lp.slope, lp.y - 30), new Point(lp.x + 30 * lp.slope, lp.y + 30), c, 4);
        }
    }
}
