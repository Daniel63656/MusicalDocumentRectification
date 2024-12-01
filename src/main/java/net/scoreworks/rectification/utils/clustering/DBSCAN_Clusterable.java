package net.scoreworks.rectification.utils.clustering;

public abstract class DBSCAN_Clusterable {
    protected DBSCAN_STATE state = DBSCAN_STATE.NOISE;
    boolean visited;

    protected enum DBSCAN_STATE {
        CORE, BORDER, NOISE
    }
}