package project;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph g=new Graph(false,false);
        Node A =new Node("A");
        Node B =new Node("B");
        Node C =new Node("C");
        g.addNode(A);
        g.addNode(B);
        g.addNode(C);

        g.addEdge(A,C);
        g.addEdge(A,B,5);
        g.addEdge(B,C);

        g.showGraph();
    }
}
