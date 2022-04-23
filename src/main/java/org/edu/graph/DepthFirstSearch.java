package org.edu.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    private Stack<Integer> stack = new Stack();
    private boolean visited[] = new boolean[4];
    private List<Integer> results = new ArrayList();

    public void traverse(GraphRepresentation graphRepresentation, int start) {
        stack.push(start);
        visited[start] = true;
        while(!stack.empty()) {
            Integer x = stack.pop();
            results.add(x);
            List<Integer> adjacencyList = graphRepresentation.adjacentVertices(x);
            System.out.println(adjacencyList);
            for (Integer i: adjacencyList) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphRepresentation graphRepresentation = new GraphRepresentation(4);
        graphRepresentation.addEdgeForDirectedGraph(0, 1);
        graphRepresentation.addEdgeForDirectedGraph(0, 2, true);
        graphRepresentation.addEdgeForDirectedGraph(1, 2);
        graphRepresentation.addEdgeForDirectedGraph(2, 3);
        graphRepresentation.addEdgeForDirectedGraph(3, 3);

        graphRepresentation.print();

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.traverse(graphRepresentation, 2);
        System.out.println(dfs.results);
    }
}
