package net.scoreworks.rectification.utils.clustering;

import java.util.*;

import net.scoreworks.rectification.utils.clustering.DBSCAN_Clusterable.DBSCAN_STATE;

public class DBSCAN<T extends DBSCAN_Clusterable> {
    private final NeighbourhoodProvider<T> neighbourhoodProvider;
    private final List<Cluster<T>> clusters = new ArrayList<>();
    private final SortedMap<Float, T> dataPoints;
    private final float epsilon;
    private final int minPts;

    @FunctionalInterface
    public interface NeighbourhoodProvider<T extends DBSCAN_Clusterable> {
        List<T> getNeighborhood(T dataPoint, SortedMap<Float, T> data, float epsilon);
    }

    public DBSCAN(NeighbourhoodProvider<T> neighbourhoodProvider, SortedMap<Float, T> dataPoints, float epsilon, int minPts) {
        this.neighbourhoodProvider = neighbourhoodProvider;
        this.dataPoints = dataPoints;
        this.epsilon = epsilon;
        this.minPts = minPts;
    }

    public List<Cluster<T>> getClusters() {
        return Collections.unmodifiableList(clusters);
    }

    public List<T> getNoise() {
        List<T> noise = new ArrayList<>();
        for (T datapoint : dataPoints.values()) {
            if (datapoint.state == DBSCAN_STATE.NOISE) {
                noise.add(datapoint);
            }
        }
        return noise;
    }

    public float getEpsilon() {
        return epsilon;
    }

    public int getMinPts() {
        return minPts;
    }

    public DBSCAN<T> fit() {
        for (T dataPoint : dataPoints.values()) {
            if (dataPoint.visited)
                continue;
            dataPoint.visited = true;
            List<T> neighbours = neighbourhoodProvider.getNeighborhood(dataPoint, dataPoints, epsilon);
            if (neighbours.size() >= minPts)  {
                Cluster<T> cluster = new Cluster<>(this, dataPoint, neighbours);
                clusters.add(cluster);
            }
            //else: noise by default
        }
        return this;
    }

    public static class Cluster<T extends DBSCAN_Clusterable> {
        private final List<T> points = new ArrayList<>();

        public Cluster(DBSCAN<T> dbscan, T dataPoint, List<T> neighboursToProcess) {
            //keep track of which points are already in neighborhood
            Set<T> neighborhood = new HashSet<>(neighboursToProcess);

            points.add(dataPoint);
            dataPoint.state = DBSCAN_STATE.CORE;
            for (int i=0; i<neighboursToProcess.size(); i++) {
                T dataPoint_ = neighboursToProcess.get(i);
                boolean noAssignedCluster = dataPoint_.state == DBSCAN_STATE.NOISE;
                if (!dataPoint_.visited) {
                    dataPoint_.visited = true;
                    dataPoint_.state = DBSCAN_STATE.BORDER;
                    Collection<T> neighbours_ = dbscan.neighbourhoodProvider.getNeighborhood(dataPoint_, dbscan.dataPoints, dbscan.epsilon);
                    if (neighbours_.size() >dbscan. minPts) {
                        dataPoint_.state = DBSCAN_STATE.CORE;
                        for (T neighbour : neighbours_) {
                            if (!neighborhood.contains(neighbour)) {
                                neighboursToProcess.add(neighbour);
                                neighborhood.add(neighbour);
                            }
                        }
                    }
                }
                //datapoint_ is not yet assigned to a cluster (currently considered noise)
                if (noAssignedCluster) {
                    points.add(dataPoint_);
                }
            }
        }

        public List<T> getPoints() {
            return points;
        }
    }
}