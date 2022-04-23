package org.edu.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {
    private boolean visited[] = new boolean[4];
    private LinkedList<Integer> queue = new LinkedList<>();
    private List<Integer> results = new ArrayList();

    public void traverse(GraphRepresentation graphRepresentation, int start) {
        if (visited[start]) {
            if (!queue.isEmpty()) {
                traverse(graphRepresentation, queue.pop());
            } else {
                return;
            }
        }
        List<Integer> adjacentVertices = graphRepresentation.adjacentVertices(start);
        visited[start] = true;
        results.add(start);
        System.out.println("Results->" + start);
        if (null == adjacentVertices || 0 == adjacentVertices.size()) {
            return;
        }
        for (int node: adjacentVertices) {
            queue.push(node);
        }
        traverse(graphRepresentation, queue.pop());
    }

    public static void main(String[] args) {
        List outputList = new ArrayList();
        GraphRepresentation graphRepresentation = new GraphRepresentation(4);
        graphRepresentation.addEdgeForDirectedGraph(0, 1);
        graphRepresentation.addEdgeForDirectedGraph(0, 2, true);
        graphRepresentation.addEdgeForDirectedGraph(1, 2);
        graphRepresentation.addEdgeForDirectedGraph(2, 3);
        graphRepresentation.addEdgeForDirectedGraph(3, 3);

        graphRepresentation.print();

        int start = 2;

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.traverse(graphRepresentation, start);
        System.out.println("Final Output:" + bfs.results);
    }
}
