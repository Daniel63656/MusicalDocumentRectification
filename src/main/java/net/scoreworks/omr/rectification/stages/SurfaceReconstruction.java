package net.scoreworks.omr.rectification.stages;

import net.scoreworks.arpackj.eig.SymmetricArpackSolver;
import org.la4j.Matrix;
import org.la4j.matrix.sparse.CRSMatrix;
import org.math.plot.Plot3DPanel;
import org.opencv.core.Point;

import java.awt.*;
import java.util.List;

import static net.scoreworks.arpackj.eig.MatrixDecomposition.eigsh_shiftInvert;

/**
 * Reconstruct the 3D surface based on a 2D mesh
 */
public class SurfaceReconstruction {
    private static final float LAMBDA = 0.4f;
    private final List<Point[]> meshPoints; //(i, j)
    private final int N_i, N_j, N_p;
    private final double[] coord3d;

    public SurfaceReconstruction(List<Point[]> meshPoints, int N_longitudes, int N_latitudes, int rows, int cols) {
        this.meshPoints = meshPoints;
        this.N_i = N_longitudes;
        this.N_j = N_latitudes;
        N_p = (N_i-1)*(N_j-1);

        //these data are specific to Samsung Galaxy s9 main camera
        float FOV;
        if (rows > cols)
            FOV = 54.2f;    //portrait mode -> vertical FOV
        else FOV = 68.6f;   //landscape mode -> horizontal FOV
        float focal_length = (float) (cols/2 / Math.tan(FOV*Math.PI/180/2));   //in pixels
        coord3d = estimate3dShape(LAMBDA, cols/2f, rows/2f, focal_length);
        //plot();
    }

    public Point getWarpingMesh(int i, int j) {
        return meshPoints.get(i)[j];
    }

    public double get3dMeshX(int i, int j) {
        return coord3d[3*(j*N_i+i)];
    }

    public double get3dMeshY(int i, int j) {
        return coord3d[3*(j*N_i+i)+1];
    }

    public double get3dMeshZ(int i, int j) {
        return coord3d[3*(j*N_i+i)+2];
    }

    public int N_i() {
        return N_i;
    }

    public int N_j() {
        return N_j;
    }

    /**
     * @return the 3D coordinates estimated by solving the regularized optimization problem
     */
    private double[] estimate3dShape(double lambda, float x_offset, float y_offset, float focal_length) {
        int i, j;  //indices ot top left corner of grid cell

        //initialize TRANSPOSED matrices so multiplyByItsTranspose() can be later used to obtain A^T*A
        Matrix A_t = new CRSMatrix(3 * N_i * N_j, 3 * N_p);
        for (int p=0; p<N_p; p++) {
            i = p % (N_i-1);
            j = p / (N_i-1);
            //put x constrained
            A_t.set(3*(j*N_i+i), 3*p, -1);
            A_t.set(3*(j*N_i+i)+3, 3*p, 1);
            A_t.set(3*((j+1)*N_i+i), 3*p, 1);
            A_t.set(3*((j+1)*N_i+i)+3, 3*p, -1);
            //put y constrained
            A_t.set(3*(j*N_i+i)+1, 3*p+1, -1);
            A_t.set(3*(j*N_i+i)+4, 3*p+1, 1);
            A_t.set(3*((j+1)*N_i+i)+1, 3*p+1, 1);
            A_t.set(3*((j+1)*N_i+i)+4, 3*p+1, -1);
            //put z constrained
            A_t.set(3*(j*N_i+i)+2, 3*p+2, -1);
            A_t.set(3*(j*N_i+i)+5, 3*p+2, 1);
            A_t.set(3*((j+1)*N_i+i)+2, 3*p+2, 1);
            A_t.set(3*((j+1)*N_i+i)+5, 3*p+2, -1);
        }

        Matrix B_t = new CRSMatrix(3 * N_i * N_j, 2 * N_i * N_j);
        for (int k=0; k<N_i*N_j; k++) {
            i = k % N_i;
            j = k / N_i;
            //put X_i - x_i*Z constrained
            B_t.set(3*k, 2*k, 1);
            B_t.set(3*k+2, 2*k, -meshPoints.get(i)[j].x + x_offset);
            //put Y_i - y_i*Z constrained
            B_t.set(3*k+1, 2*k+1, 1);
            B_t.set(3*k+2, 2*k+1, -meshPoints.get(i)[j].y + y_offset);
        }
        // Compute A^T*A + lambda * B^T*B
        Matrix AtA = A_t.multiplyByItsTranspose();
        Matrix BtB = B_t.multiplyByItsTranspose();
        Matrix M = AtA.add(BtB.multiply(lambda));

        SymmetricArpackSolver solver = eigsh_shiftInvert(M, null,  1, "LM", 0, null, 500, 1e-12);
        solver.solve();
        double[] result = solver.getEigenvectors();

        //instead of dividing x and y by f, I multiply Z by f
        for (i=2; i<result.length; i+=3) {
            result[i] *= focal_length;
        }
        return result;
    }

    /**
     * @return the 3D coordinates estimated by solving the optimization problem without regularization
     */
    private double[] estimate3dShape(float x_offset, float y_offset) {
        int i, j;  //indices ot top left corner of grid cell

        //initialize TRANSPOSED matrices so multiplyByItsTranspose() can be later used to obtain A^T*A
        Matrix A_t = new CRSMatrix(N_i * N_j, 3 * N_p);
        for (int p=0; p<N_p; p++) {
            i = p % (N_i-1);
            j = p / (N_i-1);
            //put x constrained
            A_t.set(j*N_i+i, 3*p, -meshPoints.get(i)[j].x + x_offset);
            A_t.set(j*N_i+i+1, 3*p, meshPoints.get(i+1)[j].x - x_offset);
            A_t.set((j+1)*N_i+i, 3*p, meshPoints.get(i)[j+1].x - x_offset);
            A_t.set((j+1)*N_i+i+1, 3*p, -meshPoints.get(i+1)[j+1].x + x_offset);
            //put y constrained
            A_t.set(j*N_i+i, 3*p+1, -meshPoints.get(i)[j].y + y_offset);
            A_t.set(j*N_i+i+1, 3*p+1, meshPoints.get(i+1)[j].y - y_offset);
            A_t.set((j+1)*N_i+i, 3*p+1, meshPoints.get(i)[j+1].y - y_offset);
            A_t.set((j+1)*N_i+i+1, 3*p+1, -meshPoints.get(i+1)[j+1].y + y_offset);
            //put z constrained
            A_t.set(j*N_i+i, 3*p+2, -1);
            A_t.set(j*N_i+i+1, 3*p+2, 1);
            A_t.set((j+1)*N_i+i, 3*p+2, 1);
            A_t.set((j+1)*N_i+i+1, 3*p+2, -1);
        }

        // Compute A^T*A
        Matrix AtA = A_t.multiplyByItsTranspose();
        SymmetricArpackSolver solver = eigsh_shiftInvert(AtA, null,  1, "LM", 0, null, 500, 1e-9);
        solver.solve();
        return solver.getEigenvectors();
    }


    private void plot() {
        Plot3DPanel plot = new Plot3DPanel();

        //plot latitudes
        double[] x = new double[N_i];
        double[] y = new double[N_i];
        double[] z = new double[N_i];
        for (int j=0; j<N_j; j++) {
            for (int i=0; i<N_i; i++) {
                x[i] = coord3d[3*(j*N_i+i)];
                y[i] = coord3d[3*(j*N_i+i)+1];
                z[i] = coord3d[3*(j*N_i+i)+2];
            }
            plot.addLinePlot("Mesh", Color.RED, x, y, z);
        }

        //plot longitudes
        x = new double[N_j];
        y = new double[N_j];
        z = new double[N_j];
        for (int i=0; i<N_i; i++) {
            for (int j=0; j<N_j; j++) {
                x[j] = coord3d[3*(j*N_i+i)];
                y[j] = coord3d[3*(j*N_i+i)+1];
                z[j] = coord3d[3*(j*N_i+i)+2];
            }
            plot.addLinePlot("Mesh", Color.BLUE, x, y, z);
        }

        plot.setAxisLabels("X", "Y", "Z");
        // Turn off the gridlines in the XY, XZ, and YZ planes
        plot.getAxis(0).setGridVisible(false);
        plot.getAxis(1).setGridVisible(false);
        plot.getAxis(2).setGridVisible(false);
        javax.swing.JFrame frame = new javax.swing.JFrame("3D Sheet structure");
        frame.setContentPane(plot);
        frame.setSize(700, 700);
        frame.setVisible(true);
    }

    private void plot(double[] Z) {
        Plot3DPanel plot = new Plot3DPanel();

        //plot latitudes
        double[] x = new double[N_i];
        double[] y = new double[N_i];
        double[] z = new double[N_i];
        for (int j=0; j<N_j; j++) {
            for (int i=0; i<N_i; i++) {
                x[i] = meshPoints.get(i)[j].x*Z[j*(N_i)+i];
                y[i] = meshPoints.get(i)[j].y*Z[j*(N_i)+i];
                z[i] = Z[j*(N_i)+i];
            }
            plot.addLinePlot("Mesh", Color.RED, x, y, z);
        }

        //plot longitudes
        x = new double[N_j];
        y = new double[N_j];
        z = new double[N_j];
        for (int i=0; i<N_i; i++) {
            for (int j=0; j<N_j; j++) {
                x[j] = meshPoints.get(i)[j].x*Z[j*(N_i)+i];
                y[j] = meshPoints.get(i)[j].y*Z[j*(N_i)+i];
                z[j] = Z[j*(N_i)+i];
            }
            plot.addLinePlot("Mesh", Color.BLUE, x, y, z);
        }

        plot.setAxisLabels("X", "Y", "Z");
        // Turn off the gridlines in the XY, XZ, and YZ planes
        plot.getAxis(0).setGridVisible(false);
        plot.getAxis(1).setGridVisible(false);
        plot.getAxis(2).setGridVisible(false);
        javax.swing.JFrame frame = new javax.swing.JFrame("3D Sheet structure");
        frame.setContentPane(plot);
        frame.setSize(700, 700);
        frame.setVisible(true);
    }
}