package net.scoreworks.omr.utils.clustering;

import java.util.*;

public class MeanShift {
    private static final int MAX_ITER = 100;
    private final int dim;
    private final int numData;
    private final float[] data;
    private final float bandwidth;
    private final float sigma;
    private final List<Cluster> clusters = new ArrayList<>();
    private Cluster[] labels;

    public MeanShift(float[] data, int dim, float bandwidth, float sigma) {
        if (data.length % dim != 0)
            throw new RuntimeException("Dimensionality error!");
        this.data = data;
        this.dim = dim;
        numData = data.length/dim;
        this.bandwidth = bandwidth;
        this.sigma = sigma;
    }

    public void fit() {
        meanShift();
        removeDuplicateClusters();

        //label data according to their nearest cluster
        labels = new Cluster[numData];
        for (int i=0; i<data.length; i+=dim) {
            float minDist = Float.MAX_VALUE;
            for (Cluster cluster : clusters) {
                float dist = euclideanDistance(data, i, cluster.mean);
                if (dist < minDist) {
                    minDist = dist;
                    labels[i/dim] = cluster;
                }
            }
            //increase size of the cluster that was nearest
            labels[i/dim].size++;
        }
    }

    private void meanShift() {
        List<Cluster> pending = new ArrayList<>();

        //consider data
        for (int iter=0; iter<MAX_ITER; iter++) {
            for (int i=0; i<data.length; i += dim) {
                boolean considered = false;
                for (Cluster cluster : pending) {
                    if (cluster.considerDataPoint(data, i, bandwidth, sigma))
                        considered = true;
                }
                //create new cluster if this datapoint didn't get considered by any cluster
                if (iter == 0 && !considered) {
                    float[] pos = new float[dim];
                    System.arraycopy(data, i, pos, 0, dim);
                    pending.add(new Cluster(pos));
                }
            }

            //check if clusters converged
            for (int i=0; i<pending.size(); i++) {
                Cluster cluster = pending.get(i);
                if (cluster.converged()) {
                    clusters.add(cluster);
                    pending.remove(i);
                    i--;
                }
            }

            if (pending.isEmpty())
                break;
        }
    }

    private void removeDuplicateClusters() {
        for (int i=0; i<clusters.size(); i++) {
            for (int j=i+1; j<clusters.size(); j++) {
                Cluster c1 = clusters.get(i);
                Cluster c2 = clusters.get(j);

                if (euclideanDistance(c1.mean, 0, c2.mean) <= bandwidth) {
                    //keep the one with more data
                    if (c1.depth < c2.depth) {
                        clusters.remove(i);
                        i--;
                        break;
                    }
                    else {
                        clusters.remove(j);
                        j--;
                    }
                }
            }
        }
    }
    
    public Cluster[] getLabels() {
        return labels;
    }

    public int getNumberOfClusters() {
        return clusters.size();
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(clusters);
    }

    public Cluster getStrongestCluster() {
        Cluster res = clusters.get(0);
        for (Cluster cluster : clusters) {
            if (cluster.size > res.size)
                res = cluster;
        }
        return res;
    }

    public Cluster[] getNStrongestClusters(int n) {
        if (n > clusters.size())
            throw new RuntimeException("Cannot return more clusters than there are");
        int minIdx = 0;
        Cluster[] res = new Cluster[n];

        //initialize with first n clusters
        for (int i=0; i<n; i++) {
            res[i] = clusters.get(i);
            if (res[i].size < res[minIdx].size) {
                minIdx = i;
            }
        }
        //loop over rest
        for (int i=n; i<clusters.size(); i++) {
            if (clusters.get(i).size > res[minIdx].size) {
                res[minIdx] = clusters.get(i);
                //recalculate minIdx
                float min = Float.MAX_VALUE;
                for (int j=0; j<n; j++) {
                    if (res[j].size < min) {
                        min = res[j].size;
                        minIdx = j;
                    }
                }
            }
        }
        return res;
    }

    static float euclideanDistance(float[] data1, int idx1, float[] mean) {
        float squares = 0;
        for (int i=0; i<mean.length; i++) {
            squares += (data1[idx1+i]-mean[i])*(data1[idx1+i]-mean[i]);
        }
        return (float) Math.sqrt(squares);
    }


    public static class Cluster {
        private final float[] mean;
        private final float[] runningMean;
        private float depth;
        private float runningDepth;
        private int size;
        
        Cluster(float[] position) {
            this.mean = position;
            runningMean = new float[mean.length];
        }

        public float[] getPosition() {
            return mean;
        }

        public int size() {
            return size;
        }

        private boolean considerDataPoint(float[] data, int idx, float bandwidth, float sigma) {
            float dist = euclideanDistance(data, idx, mean);
            if (dist <= bandwidth) {
                //weight using a gaussian with sigma = bandwidth/sigmaAtBandwidth
                float weight = (float) (Math.exp(-sigma*sigma/2f * dist*dist/bandwidth/bandwidth));
                runningDepth += weight;
                for (int j=0; j<runningMean.length; j++) {
                    runningMean[j] += weight * data[idx + j];
                }
                return true;
            }
            return false;
        }
        
        private boolean converged() {
            if (runningDepth > depth) {
                depth = runningDepth;

                //change mean and reset running variables for next iteration
                for (int i=0; i<mean.length; i++) {
                    mean[i] = runningMean[i]/depth;
                    runningMean[i] = 0;
                }
                runningDepth = 0;
                return false;
            }
            return true;
        }
    }
}
