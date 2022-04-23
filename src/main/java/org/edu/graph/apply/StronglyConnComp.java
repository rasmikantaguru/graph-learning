package org.edu.graph.apply;

import org.edu.graph.GraphRepresentation;

public class StronglyConnComp {

    public static void main(String[] args) {
        GraphRepresentation graphRepresentation = new GraphRepresentation(6);

        graphRepresentation.addEdgeForDirectedGraph(0, 1);
        graphRepresentation.addEdgeForDirectedGraph(1, 2);
        graphRepresentation.addEdgeForDirectedGraph(2, 0);
        graphRepresentation.addEdgeForDirectedGraph(2, 3);
        graphRepresentation.addEdgeForDirectedGraph(3, 4);
        graphRepresentation.addEdgeForDirectedGraph(4, 5);
        graphRepresentation.addEdgeForDirectedGraph(5, 3);

        graphRepresentation.print();

        System.out.println("=====Transpose=======");

        GraphRepresentation transpose = graphRepresentation.transpose();
        transpose.print();
    }
}
