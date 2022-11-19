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

    public void addEge(Node start, Node end, Integer weight) {
        if (!weighted)
            weight = null;

        if (!directed)
            end.addEdge(start, weight);

        start.addEdge(end, weight);

    }
 
    public ArrayList<Node> getVertices() {
        return vertices;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public boolean isDirected() {
        return directed;
    }

    
    
}
