import java.util.ArrayList;


public class Node {

    private String data;
    private ArrayList<Edge> edges;


    public Node(String data) {
        this.data = data;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Node endNode, Integer weight) {
        this.edges.add(new Edge(this, endNode, weight));
    }

    public void removeEdge(Node endENode) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endENode));
    }


    public String getData() {
        return data;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void print(boolean weight) {
        if (this.edges.size() == 0) {
            System.out.println(this.data+"-->");
            return;
        }
        
        String message = this.edges.get(0).getStart().data + " --> ";

        for (int i = 0; i < this.edges.size(); i++) {
            message += this.edges.get(i).getEnd().data;

            if (weight)
                message += "("+this.edges.get(i).getWeight()+")";
            
            if (i != this.edges.size()-1)
                message += ", ";             
        }

        System.out.println(message);
    }

    public static void main(String[] args) {
        Node node = new Node("1");
        node.addEdge(new Node("2"), 3);
        node.addEdge(new Node("3"), 4);
        node.addEdge(new Node("5"), 1);

        node.print(false);
    }
}
