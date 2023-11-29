package net.scoreworks.omr.utils.clustering;

import net.scoreworks.omr.utils.LinePoint;

import java.util.*;

public class MomentumClustering {
    private final DistanceFunction distanceFunction;
    private final List<Cluster> pending = new ArrayList<>();
    private final List<Cluster> clusters = new ArrayList<>();
    private final float bandwidth;
    private final float minDensity;
    private final int minPointsForDensityEstimate;
    private final int capacity;

    @FunctionalInterface
    public interface DistanceFunction {
        float distance(Cluster cluster, LinePoint dataPoint);
    }

    public MomentumClustering(DistanceFunction distanceFunction, float bandwidth, float minDensity, int minPointsForDensityEstimate, int capacity) {
        this.distanceFunction = distanceFunction;
        this.bandwidth = bandwidth;
        this.minDensity = minDensity;
        this.minPointsForDensityEstimate = minPointsForDensityEstimate;
        this.capacity = capacity;
    }

    public void feed(LinePoint dataPoint, boolean allowNewClusters) {
        Cluster claiming = null;
        int maxSize = 0;

        //let the cluster with the lowest distance take the datapoint
        for (int i=0; i<pending.size(); i++) {
            Cluster cluster = pending.get(i);
            //remove if to spread apart
            if (cluster.getDensity(dataPoint.x) < minDensity) {
                safeCluster(cluster);
                pending.remove(i);
                i--;
                continue;
            }
            //grant datapoint to biggest cluster
            float distance = distanceFunction.distance(cluster, dataPoint);
            if (distance < bandwidth && cluster.size() > maxSize) {
                claiming = cluster;
                maxSize = cluster.size();
            }
        }
        if (claiming != null) {
            claiming.take(dataPoint);
        }
        //or if no cluster takes the datapoint, make a new cluster if allowed
        else if (allowNewClusters) {
            pending.add(new Cluster(this, dataPoint));
        }
    }

    private void safeCluster(Cluster cluster) {
        if (cluster.savedPoints.isEmpty())
            return;
        for (LinePoint dataPoint : cluster.dataPoints) {
            if (distanceFunction.distance(cluster, dataPoint) < bandwidth)
                cluster.savedPoints.put(dataPoint.x, dataPoint);
        }
        clusters.add(cluster);
    }

    public void settle() {
        for (Cluster cluster : pending) {
            safeCluster(cluster);
        }
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

    public Cluster getStrongestCluster() {
        int maxSize = 0;
        Cluster biggest = null;
        for (Cluster cluster : clusters) {
            if (cluster.size() > maxSize) {
                maxSize = cluster.size();
                biggest = cluster;
            }
        }
        return biggest;
    }

    public static class Cluster {
        private final NavigableMap<Float, LinePoint> savedPoints = new TreeMap<>();
        private final List<LinePoint> dataPoints = new ArrayList<>();
        private final MomentumClustering clustering;
        private float aggregateY;
        private float aggregateAngle;

        private Cluster(MomentumClustering clustering, LinePoint dataPoint) {
            dataPoints.add(dataPoint);
            this.clustering = clustering;
            aggregateY = dataPoint.y;
            aggregateAngle = dataPoint.angle;
        }

        private float getDensity(float newPosition) {
            if (dataPoints.size() < clustering.minPointsForDensityEstimate) {
                return Float.MAX_VALUE;
            }
            float width = newPosition - dataPoints.get(0).x;
            return dataPoints.size() / width;
        }

        private void take(LinePoint dataPoint) {
            //remove dataPoint if cluster is full
            if (dataPoints.size() == clustering.capacity) {
                LinePoint removePoint = dataPoints.get(0);
                //save if still in reach otherwise discard
                if (clustering.distanceFunction.distance(this, removePoint) < clustering.bandwidth)
                    savedPoints.put(removePoint.x, removePoint);
                dataPoints.remove(0);
                //remove point features
                aggregateY -= removePoint.y;
                aggregateAngle -= removePoint.angle;
            }
            //add new point in
            dataPoints.add(dataPoint);
            aggregateY += dataPoint.y;
            aggregateAngle += dataPoint.angle;
        }

        public int size() {
            return savedPoints.size() + dataPoints.size();
        }

        public float getMeanY() {
            return aggregateY/dataPoints.size();
        }

        public float getMeanAngle() {
            return aggregateAngle/dataPoints.size();
        }

        public float getWidth() {
            if (savedPoints.isEmpty())
                return 0;
            float firstPos = savedPoints.get(savedPoints.firstKey()).x;
            float lastPos  = savedPoints.get(savedPoints.lastKey()).x;
            return lastPos - firstPos;
        }

        public NavigableMap<Float, LinePoint> getSavedPoints() {
            return savedPoints;
        }
    }
}