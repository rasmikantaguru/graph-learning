package org.edu.graph.apply;

import org.edu.graph.DepthFirstSearch;
import org.edu.graph.GraphRepresentation;
import org.edu.graph.abs.GraphStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindMotherVertex {

    public static void find(GraphStructure graphStructure) {

    }

    public boolean isReachable(GraphStructure graphStructure, Integer start, Integer end) {
        if (start.equals(end)) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> results = new ArrayList<>();

        stack.push(start);
        int adjacencyPosition = 0;

        while (!stack.isEmpty()) {
            //start = stack.pop();
            List<Integer> nodes = graphStructure.adjacentVertices(start);
            if (null == nodes || nodes.size() == 0) {
                adjacencyPosition++;
                stack.pop();
                start = stack.lastElement();
            } else if (nodes.size() > adjacencyPosition) {
                Integer node = nodes.get(adjacencyPosition);
                if (null != node && node.equals(end)) {
                    while (!stack.isEmpty()) {
                        results.add(stack.pop());
                    }
                } else {
                    stack.push(node);
                    start = node;
                }
            } else {
                start = stack.pop();
            }
        }
        System.out.println(results);
        return false;
    }

    public static void main(String[] args) {
        GraphRepresentation graphRepresentation = new GraphRepresentation(7);
        graphRepresentation.addEdgeForDirectedGraph(0, 1);
        graphRepresentation.addEdgeForDirectedGraph(0, 2);
        graphRepresentation.addEdgeForDirectedGraph(1, 3);
        graphRepresentation.addEdgeForDirectedGraph(1, 4);
        graphRepresentation.addEdgeForDirectedGraph(2, 5);
        graphRepresentation.addEdgeForDirectedGraph(5, 6);
        graphRepresentation.addEdgeForDirectedGraph(6, 4);
        graphRepresentation.addEdgeForDirectedGraph(6, 0);

        graphRepresentation.print();

        FindMotherVertex motherVertex = new FindMotherVertex();
        motherVertex.isReachable(graphRepresentation, 0, 5);
        //System.out.println(dfs.results);
    }
}
