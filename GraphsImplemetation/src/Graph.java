import java.util.ArrayList;

public class Graph {
    
    private ArrayList<Node> vertices;
    private boolean weighted, directed;

    public Graph(boolean weighted, boolean directed) {
        this.vertices = new ArrayList<Node>();
        this.weighted = weighted;
        this.directed = directed;
    }

    public Node addVertex(String data) {
        Node vertex = new Node(data);
        this.vertices.add(vertex);
        return vertex;
    }

    public void addEdge(Node start, Node end, Integer weight) {
        if (!weighted)
            weight = null;

        if (!directed)
            end.addEdge(start, weight);

        start.addEdge(end, weight);

    }
    
    public void removeVertex(Node vertex) {
        this.vertices.remove(vertex);        
    }

    public void removeEdge(Node start, Node end) {
        start.removeEdge(end);
        if (!this.directed)
            end.removeEdge(start);
    }

    public ArrayList<Node> getVertices() {
        return this.vertices;
    }

    public boolean isWeighted() {
        return this.weighted;
    }

    public boolean isDirected() {
        return this.directed;
    }

    public Node getVertexByValue(String value) {
        for (Node vertex : this.vertices) {
            if (vertex.getData().equals(value)) {
                return vertex;
            }
        }
        return null;
    }

    public void print() {
        for (Node node : this.vertices) {
            node.print(weighted);
        }
    }
    
    
    public static void main(String[] args) {
        Graph network = new Graph(true, true);
        Node vertex1 = network.addVertex("California");
        Node vertex2 = network.addVertex("Verginia");

        network.addEdge(vertex1, vertex2,300);
        network.print();        
    }
}
