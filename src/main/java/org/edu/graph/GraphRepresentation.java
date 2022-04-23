package org.edu.graph;

import org.edu.graph.abs.GraphStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GraphRepresentation implements GraphStructure {

    private Integer numOfVertex;
    private ArrayList<Integer>[] array;

    public GraphRepresentation(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        this.array = new ArrayList[numOfVertex];
        for (int i = 0; i < this.numOfVertex; i++) {
            this.array[i] = new ArrayList();
        }
    }

    public void addEdgeForUnDirectedGraph(int u, int v) {
        this.array[u].add(v);
        this.array[v].add(u);
    }

    public void addEdgeForDirectedGraph(int u, int v) {
        this.array[u].add(v);
    }

    public void addEdgeForDirectedGraph(int u, int v, boolean isBidirectional) {
        this.array[u].add(v);
        if (isBidirectional) {
            this.array[v].add(u);
        }
    }

    public int numberOfOfVertex() {
        return this.array.length;
    }

    public List<Integer> adjacentVertices(int node) {
        return this.array[node];
    }

    public void print() {
        for (int i = 0; i < this.numOfVertex; i++) {
            System.out.println(i + " => " + this.array[i]);
        }
    }

    public List<Integer>[] getMatrix() {
        return Arrays.copyOf(this.array, this.array.length);
    }

    public GraphRepresentation transpose() {
        GraphRepresentation transpose = new GraphRepresentation(this.numOfVertex);
        for (int i = 0; i < this.numOfVertex; i++) {
            for (int j = 0; j < this.array[i].size(); j++) {
                transpose.addEdgeForDirectedGraph(this.array[i].get(j), i);
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        GraphRepresentation graphRepresentation = new GraphRepresentation(5);

        graphRepresentation.addEdgeForDirectedGraph(0, 1);
        graphRepresentation.addEdgeForDirectedGraph(0, 4);
        graphRepresentation.addEdgeForDirectedGraph(1, 2);
        graphRepresentation.addEdgeForDirectedGraph(1, 3);
        graphRepresentation.addEdgeForDirectedGraph(1, 4);
        graphRepresentation.addEdgeForDirectedGraph(2, 3);
        graphRepresentation.addEdgeForDirectedGraph(3, 4);

        graphRepresentation.print();

        System.out.println("=====Transpose=======");

        GraphRepresentation transpose = graphRepresentation.transpose();
        transpose.print();
    }
}
