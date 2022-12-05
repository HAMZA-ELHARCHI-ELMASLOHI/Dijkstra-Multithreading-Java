package dd;

import java.util.Arrays;

public class DijkstraThread extends Thread {
    int src;
    Graph g=new Graph();
    public DijkstraThread(Graph g,int src,  int numOfvertices, int[][] mat) {
        this.src = src;
        this.g = g;
        this.g.numOfvertices = numOfvertices;
        this.g.adjMatrix=mat;

    }

    @Override
    public void run(){

        try {
            dijkstrasShortestPath(g,src);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getClosestVertex(int[] distance, boolean[] visited)
    {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i=0; i<distance.length; i++)
        {
            if(distance[i] < min)
                if(!visited[i])
                {
                    min = distance[i];
                    minIdx = i;
                }
        }
        return minIdx;
    }
    public static void dijkstrasShortestPath(Graph g, int src) throws InterruptedException {
        //final shortest distance array
        int[] distance = new int[g.numOfvertices];
        //array to tell whether shortest distance of vertex has been found
        boolean[] visited = new boolean[g.numOfvertices];

        //initializing the arrays
        for(int i=0; i<g.numOfvertices; i++)
        {
            distance[i] = Integer.MAX_VALUE;//initial distance is infinite
            visited[i] = false;//shortest distance for any node has not been found yet
        }
        distance[src] = 0;

        for(int i=0; i<g.numOfvertices; i++)
        {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    int closestVertex = getClosestVertex(distance, visited);
                    if(closestVertex == Integer.MAX_VALUE)
                        System.out.println(Arrays.toString(distance));
                    visited[closestVertex] = true;
                    for(int j=0; j<g.numOfvertices; j++)
                    {

                        if(!visited[j])//shortest distance of the node j should not have been finalized
                        {
                            if(g.adjMatrix[closestVertex][j] != 0)
                            {
                                int d = distance[closestVertex] + g.adjMatrix[closestVertex][j];
                                if(d < distance[j]) {//distance via closestVertex is less than the initial distance
                                    distance[j] = d;
                                }
                            }

                        }
                    }

                    System.out.println(Arrays.toString(distance)+ "Thread : "+currentThread().getName());

                }
            });
            currentThread().join(1000);
            t1.start();


        }
        System.out.println("Final: "+Arrays.toString(distance)+ "Thread : "+currentThread().getName());

    }


}
