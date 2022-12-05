package project;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph g=new Graph(true,true);
        Node A =new Node("A");
        Node B =new Node("B");
        Node C =new Node("C");
        Node D =new Node("D");
        Node E =new Node("E");
        g.addNode(A);
        g.addNode(B);
        g.addNode(C);
        g.addNode(D);
        g.addNode(E);

        g.addEdge(A,B,4);
        g.addEdge(A,C,1);
        g.addEdge(C,B,2);
        g.addEdge(B,D,1);
        g.addEdge(C,D,5);
        g.addEdge(D,E,3);

        System.out.println(g.getEdge(A));

        System.out.println(g.distance);
        System.out.println(g.visited);

        g.showGraph();
    }
}
