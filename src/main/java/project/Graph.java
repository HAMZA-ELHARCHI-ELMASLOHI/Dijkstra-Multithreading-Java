package project;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {

    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    private boolean weighted, directed;

    ArrayList<Integer> distance= new ArrayList<>();
    ArrayList<Boolean> visited=new ArrayList<>();



    public Graph(boolean weighted, boolean directed) {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();

        this.weighted = weighted;
        this.directed = directed;
    }

    public void addNode(Node node){
        nodes.add(node);
        distance.add(Integer.MAX_VALUE);
        distance.set(0,0);
        visited.add(false);
    }

    public void addEdge(Node start, Node end, int weight){
        Edge edge = new Edge(start, end, weight);

        if (!weighted){
            edge = new Edge(start, end);
        }
        edges.add(edge);
    }
    public void addEdge(Node start, Node end){
        Edge edge = new Edge(start, end);
        if (weighted){
            edge = new Edge(start, end,1);
        }
        edges.add(edge);
    }

    public void removeNode(Node node){
        nodes.remove(node);
    }
    public void removeEdge(Edge edge){
        edges.remove(edge);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Node> getEdge(Node n){
        ArrayList<Node> nodesList=new ArrayList<Node>();
        for (Edge e : edges){
            if (e.getStart().data==n.data){
                nodesList.add(e.getEnd());
            }
        }
        return nodesList;
    }

    public void showGraph(){
        if(weighted && !directed){
            for (Edge e: edges) {
                System.out.println(e.getStart().data+ "------" +e.getWeight() + "------"+e.getEnd().data);
            }
        }
        else if(weighted && directed){
            for (Edge e: edges) {
                System.out.println(e.getStart().data+ "------" +e.getWeight() + "------>"+e.getEnd().data);
            }
        }
        else if(!weighted && directed){
            for (Edge e: edges) {
                System.out.println(e.getStart().data+ "------------>"+e.getEnd().data);
            }
        }
        else{
            for (Edge e: edges) {
                System.out.println(e.getStart().data+ "------" +e.getWeight() + "------>"+e.getEnd().data);
            }
        }

    }
}
