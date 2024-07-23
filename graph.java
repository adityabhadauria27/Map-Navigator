import java.util.*;

class Graph {
    private final Map<String, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addNode(String node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        adjList.get(source).add(new Edge(destination, weight));
        adjList.get(destination).add(new Edge(source, weight)); // For undirected graph
    }

    public List<String> shortestPath(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        for (String node : adjList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
            previous.put(node, null);
        }

        distances.put(start, 0);
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.name.equals(end)) {
                return constructPath(previous, end);
            }

            for (Edge edge : adjList.get(current.name)) {
                int newDist = distances.get(current.name) + edge.weight;

                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    previous.put(edge.destination, current.name);
                    queue.add(new Node(edge.destination, newDist));
                }
            }
        }

        return Collections.emptyList();
    }

    private List<String> constructPath(Map<String, String> previous, String end) {
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    private static class Edge {
        String destination;
        int weight;

        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static class Node {
        String name;
        int distance;

        Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }
}

