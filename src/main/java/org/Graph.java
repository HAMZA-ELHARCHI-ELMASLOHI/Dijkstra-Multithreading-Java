package org;

class Graph
{
    int[][] adjMatrix;
    int numOfvertices;

        Graph(int[][] mat, int v)
    {
        this.adjMatrix = mat;
        this.numOfvertices = v;
    }
    Graph()
    {

    }

    void addEdge(int src, int dest, int edgeWeight)
    {
        adjMatrix[src][dest] = edgeWeight;
        adjMatrix[dest][src] = edgeWeight;
    }


}