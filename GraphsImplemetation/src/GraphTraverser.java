import java.util.ArrayList;

public class GraphTraverser {
    public static void depthFirstTraversal(Node start, ArrayList<Node> visited) {
        System.out.println(start.getData());
       
        for (Edge edge : start.getEdges()) {
            Node vertex = edge.getEnd();

            if(!visited.contains(vertex)){
                visited.add(vertex);
                GraphTraverser.depthFirstTraversal(vertex, visited);
            }
        }
    }

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Node start = test.getStartingVertex();
        ArrayList<Node> visited = new ArrayList<Node>();
        visited.add(start);

        GraphTraverser.depthFirstTraversal(start, visited);
    }
}
