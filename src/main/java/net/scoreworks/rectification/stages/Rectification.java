package net.scoreworks.rectification.stages;

import net.scoreworks.rectification.stages.StaffDetection.StaffModel;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.*;

import static net.scoreworks.rectification.utils.Utils.median;

/**
 *
 */
public class Rectification {
    private final SurfaceReconstruction r;
    private final Mat rectified;
    private final float iss_r;

    public Rectification(Mat img, List<StaffModel> staffs, SurfaceReconstruction surfaceReconstruction, float iss, int rows, int cols) {
        this.r = surfaceReconstruction;
        iss_r = iss;
        float[] latitudeSpacing = estimateLatitudeSpacing(staffs, rows, cols);
        rectified = rectifyImage(img, staffs, latitudeSpacing, estimateLongitudeSpacing(latitudeSpacing));
    }

    public Mat getRectifiedImage() {
        return rectified;
    }

    /**
     * estimate the distances between latitudes delta v based on cross-ratio
     */
    public float[] estimateLatitudeSpacing(List<StaffModel> staffs, int rows, int cols) {
        float[] heights = new float[staffs.size()+1];
        float scale = (staffs.get(0).getPosition(4) - staffs.get(0).getPosition(0)) / 5;
        heights[0] = staffs.get(0).staffHeight(cols/2f, 2) * iss_r/scale;
        float AB, BC, CD, lambda;
        for (int i=0; i<staffs.size()-1; i++) {
            AB = (staffs.get(i).getPosition(4) - staffs.get(i).getPosition(0));
            CD = (staffs.get(i+1).getPosition(4) - staffs.get(i+1).getPosition(0));
            BC = staffs.get(i+1).staffHeight(cols/2f, 2) - staffs.get(i).staffHeight(cols/2f, 2);
            lambda = (AB+BC)*(BC+CD)/(BC*(AB+BC+CD));
            heights[i+1] = (float) (heights[i] + 5* iss_r *(Math.sqrt(lambda*(lambda-1))-lambda+1) / (lambda-1));
        }

        //set last height as rectified image height
        int idx = staffs.size()-1;
        scale = (staffs.get(idx).getPosition(4) - staffs.get(idx).getPosition(0)) / 5;
        heights[staffs.size()] = heights[staffs.size()-1] + (rows - staffs.get(idx).staffHeight(cols/2f, 2)) * iss_r/scale;
        return heights;
    }

    /**
     * estimate the distances between longitudes delta u by relating 3D lengths to 2D lengths of
     * the parallelograms
     */
    public float[] estimateLongitudeSpacing(float[] latitudeSpacing) {
        float[] widths = new float[r.N_i()+1];
        widths[0] = 8* iss_r;    //pad out start
        List<Float> estimations = new ArrayList<>();
        double a, b = 0, x, y, z;
        for (int i = 0; i< r.N_i()-1; i++) {
            estimations.clear();
            for (int j = 0; j< r.N_j(); j++) {
                // a/b = c/d
                x = r.get3dMeshX(i, j);
                y = r.get3dMeshY(i, j);
                z = r.get3dMeshZ(i, j);
                a = Math.sqrt(
                          Math.pow(r.get3dMeshX(i+1, j) - x, 2)
                        + Math.pow(r.get3dMeshY(i+1, j) - y, 2)
                        + Math.pow(r.get3dMeshZ(i+1, j) - z, 2));
                if (j < r.N_j()-1) {
                    b = Math.sqrt(
                              Math.pow(r.get3dMeshX(i, j+1) - x, 2)
                            + Math.pow(r.get3dMeshY(i, j+1) - y, 2)
                            + Math.pow(r.get3dMeshZ(i, j+1) - z, 2));
                    estimations.add((float) ((latitudeSpacing[j+1] - latitudeSpacing[j]) * a / b));
                }
                else {
                    //lowest segment, reuse a from previous iteration
                    estimations.add((float) ((latitudeSpacing[j] - latitudeSpacing[j-1]) * a / b));
                }
            }

            //increase new width by median value
            estimations.sort(Comparator.comparingDouble(Float::floatValue));
            widths[i+1] = widths[i] + median(estimations);
        }
        //pad out end
        widths[r.N_i()] = widths[r.N_i()-1] + 8*iss_r;
        return widths;
    }

    public Mat rectifyImage(Mat img, List<StaffModel> staffs, float[] latitudeSpacing, float[] longitudeSpacing) {
        //create the output image matrix and transformation maps
        Size size = new Size(longitudeSpacing[longitudeSpacing.length-1], latitudeSpacing[latitudeSpacing.length-1]);
        Mat rectified = new Mat(size, img.type());
        Mat map1 = new Mat(rectified.size(), CvType.CV_32FC1);    //x coordinates
        Mat map2 = new Mat(rectified.size(), CvType.CV_32FC1);    //y coordinates

        //generate the mapping which for every pixel in the destination image, tell where it comes from in the
        //source image according to P(s,t) = t*latitude_btm(s) + (1-t)*latitude_top(s)
        float s, t, x1, y1, x2, y2;
        int latitude = 1;
        int longitude;
        for (int v=0; v<rectified.rows(); v++) {
            longitude = 1;
            if (v > latitudeSpacing[latitude] && latitude < latitudeSpacing.length-2)
                latitude++;
            //t*btm + (1-t)*top = v <=> t = (v-top)/(btm-top)
            t = (v - latitudeSpacing[latitude-1]) / (latitudeSpacing[latitude] - latitudeSpacing[latitude-1]);

            for (int u=0; u<rectified.cols(); u++) {
                if (u > longitudeSpacing[longitude] && longitude < longitudeSpacing.length-2)
                    longitude++;
                //s*rgt + (1-s)*lft = u <=> s = (u-lft)/(rgt-lft)
                s = (u - longitudeSpacing[longitude-1]) / (longitudeSpacing[longitude] - longitudeSpacing[longitude-1]);

                //interpolate points from top and bottom curves
                x1 = (float) (s* r.getWarpingMesh(longitude, latitude-1).x
                        + (1-s)* r.getWarpingMesh(longitude-1, latitude-1).x);
                y1 = staffs.get(latitude-1).staffHeight(x1, 2);
                x2 = (float) (s* r.getWarpingMesh(longitude, latitude).x
                        + (1-s)* r.getWarpingMesh(longitude-1, latitude).x);
                y2 = staffs.get(latitude).staffHeight(x2, 2);
                //blend between those points
                map1.put(v, u, t*x2 + (1-t)*x1);
                map2.put(v, u, t*y2 + (1-t)*y1);
            }
        }
        Imgproc.remap(img, rectified, map1, map2, Imgproc.INTER_LINEAR);
        return rectified;
    }
}