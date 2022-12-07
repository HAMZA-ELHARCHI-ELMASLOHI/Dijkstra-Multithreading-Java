package org;

public class mainThread {
    // this is using MultiThreading
    public static void main(String[] args) {

        int numOfVertices = 5;
        int[][] adjMat = new int[numOfVertices+1][numOfVertices+1];
        Graph graph = new Graph(adjMat, numOfVertices);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(3, 3, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);


        DijkstraThread dj1 = new DijkstraThread(graph, 0,numOfVertices, adjMat);
        DijkstraThread dj2 = new DijkstraThread(graph, 1,numOfVertices, adjMat);
        DijkstraThread dj3 = new DijkstraThread(graph, 4,numOfVertices, adjMat);


        //DijkstraThread dj2 = new DijkstraThread();

        dj1.start();
        dj2.start();

    }
}
