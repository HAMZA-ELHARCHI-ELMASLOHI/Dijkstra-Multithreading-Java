package org;

public class Dijkstra {

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
    public static int[] dijkstrasShortestPath(Graph g, int src)
    {
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
            int closestVertex = getClosestVertex(distance, visited);
            if(closestVertex == Integer.MAX_VALUE)
                return distance;

            visited[closestVertex] = true;
            for(int j=0; j<g.numOfvertices; j++)
            {
                if(!visited[j])//shortest distance of the node j should not have been finalized
                {
                    if(g.adjMatrix[closestVertex][j] != 0)
                    {
                        int d = distance[closestVertex] + g.adjMatrix[closestVertex][j];
                        if(d < distance[j])//distance via closestVertex is less than the initial distance
                            distance[j] = d;
                    }
                }
            }
        }
        return distance;
    }
}
