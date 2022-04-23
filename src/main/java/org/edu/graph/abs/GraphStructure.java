package org.edu.graph.abs;

import java.util.List;

public interface GraphStructure {
    void addEdgeForUnDirectedGraph(int u, int v);
    void addEdgeForDirectedGraph(int u, int v);
    int numberOfOfVertex();
    List<Integer> adjacentVertices(int node);
    void print();
}
