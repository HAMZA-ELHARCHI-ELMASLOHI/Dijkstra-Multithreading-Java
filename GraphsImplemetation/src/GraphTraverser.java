import java.util.ArrayList;

public class GraphTraverser {

    public static void depthFirstTraversal(Node start, ArrayList<Node> visited) {
        System.out.println(start.getData());
        // visited.add(start);

        for (Edge edge : start.getEdges()) {
            Node neighboor = edge.getEnd();         

            if(!visited.contains(neighboor)){
                visited.add(neighboor);
                GraphTraverser.depthFirstTraversal(neighboor, visited);
            }
        }
    }

    public static void breathFirstSearch(Node start, ArrayList<Node> visited){
        System.out.println(start.getData());

        for (Edge edge : start.getEdges()) {
            Node neighboor = edge.getEnd();         

            if(!visited.contains(neighboor)){
                visited.add(neighboor);
                GraphTraverser.depthFirstTraversal(neighboor, visited);
            }
            else
                visited.remove(neighboor);
        }
    }


    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Node start = test.getStartingVertex();
        ArrayList<Node> visited = new ArrayList<Node>();
        visited.add(start);

        // GraphTraverser.depthFirstTraversal(start, visited);
        GraphTraverser.breathFirstSearch(start, visited);

        System.out.println("--------------------------------------");

        Graph graph = new Graph(false, true);

        Node v1 = graph.addVertex("1");
        Node v2 = graph.addVertex("2");
        Node v3 = graph.addVertex("3");
        Node v4 = graph.addVertex("4");
        Node v5 = graph.addVertex("5");
        
        graph.addEdge(v1, v3, null);
        graph.addEdge(v1, v4, null);
        graph.addEdge(v3, v4, null);
        graph.addEdge(v3, v2, null);
        graph.addEdge(v2, v5, null);


        Node start2 = graph.getVertexByValue("1"); 
        GraphTraverser.depthFirstTraversal(start2, new ArrayList<Node>());
        // GraphTraverser.breathFirstSearch(start2, visited);

    }
}
