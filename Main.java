import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // Add edges
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 3);


        List<String> path = graph.shortestPath("A", "E");
        System.out.println("Shortest path from A to E: " + path);
    }
}
