package dd;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        int numOfVertices = 5;
        int[][] adjMat = new int[6][6];
        Graph graph = new Graph(adjMat, numOfVertices);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);
        int[] dist = Dijkstra.dijkstrasShortestPath(graph, 0);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(adjMat[i][j]);
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(dist));



    }

}
