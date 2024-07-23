### Map Navigator Description

#### Overview

The provided Java implementation of a Map Navigator is designed to model and navigate a map using a graph-based approach. It uses an adjacency list to represent the graph structure and employs Dijkstra's algorithm to find the shortest path between two nodes. This implementation is useful for applications such as route planning, navigation systems, and network analysis.

#### Components

1. **Graph Class**:
   - **Purpose**: Manages the graph structure, including nodes and edges. Provides functionality to add nodes and edges and to compute the shortest path between nodes.
   - **Key Methods**:
     - `addNode(String node)`: Adds a new node to the graph.
     - `addEdge(String source, String destination, int weight)`: Creates a bi-directional edge between two nodes with a specified weight.
     - `shortestPath(String start, String end)`: Finds the shortest path between the start and end nodes using Dijkstra's algorithm. Returns a list of nodes representing the shortest path.
   - **Inner Classes**:
     - `Edge`: Represents an edge in the graph with a destination node and a weight.
     - `Node`: Represents a node in the priority queue for Dijkstra's algorithm, storing the node's name and current shortest distance from the start node.

2. **Main Class**:
   - **Purpose**: Demonstrates the usage of the `Graph` class. Initializes a sample graph with nodes and edges, and computes the shortest path between two specific nodes.
   - **Key Operations**:
     - Adds nodes representing locations.
     - Adds edges representing paths between locations with associated weights (e.g., distances or travel times).
     - Computes and prints the shortest path from a starting node to a destination node.

#### Functionality

1. **Graph Representation**:
   - The graph is represented using an adjacency list stored in a `HashMap`. Each key in the map corresponds to a node, and the value is a list of `Edge` objects representing the adjacent nodes and the weights of the edges.

2. **Shortest Path Calculation**:
   - Dijkstra's algorithm is used to find the shortest path from the start node to the end node. This algorithm efficiently finds the shortest path in a weighted graph using a priority queue to explore nodes with the smallest known distance first.

3. **Path Construction**:
   - Once the shortest path is computed, the `constructPath` method reconstructs the path from the start node to the end node by backtracking through the `previous` map, which stores the preceding node for each node in the shortest path.

#### Example Usage

In the example provided:
- A graph with nodes "A", "B", "C", "D", and "E" is created.
- Edges with weights are added to represent paths between these nodes.
- The shortest path from node "A" to node "E" is computed and printed, demonstrating the functionality of the `shortestPath` method.

This implementation can be extended and adapted for various applications that require efficient pathfinding and navigation on a graph-based map.
