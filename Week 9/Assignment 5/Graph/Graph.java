package Graph;

import java.util.*;

//create a graph class to store all the cities and their connections
public class Graph {
    private Node[] nodes;
    private int size;

    public Graph(int size) {
        this.size = size;
        nodes = new Node[size];
    }

    public void addNode(String name) {
        for (int i = 0; i < size; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node(name);
                break;
            }
        }
    }

    public Node getNode(String name) {
        for (int i = 0; i < size; i++) {
            if (nodes[i].name.equals(name)) {
                return nodes[i];
            }
        }
        return null;
    }

    public Edge getEdge(String city1, String city2) {
        Node node1 = getNode(city1);
        Node node2 = getNode(city2);
        if (node1 != null && node2 != null) {
            for (int i = 0; i < node1.edges.length; i++) {
                if (node1.edges[i] != null) {
                    if (node1.edges[i].node1.name.equals(city1) && node1.edges[i].node2.name.equals(city2)) {
                        return node1.edges[i];
                    }
                }
            }
        }
        return null;
    }

    public void addEdge(String city1, String city2, int price) {
        Node node1 = null;
        Node node2 = null;
        for (int i = 0; i < size; i++) {
            if (nodes[i].name.equals(city1)) {
                node1 = nodes[i];
            }
            if (nodes[i].name.equals(city2)) {
                node2 = nodes[i];
            }
        }
        if (node1 != null && node2 != null) {
            node1.addEdge(node2, price);
            node2.addEdge(node1, price);
        }
    }

    public void printGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print(nodes[i].getName() + ": ");
            nodes[i].printEdges();
        }
    }

    public int shortestPath(String startCity, String endCity) {
        Node startNode = getNode(startCity);
        Node endNode = getNode(endCity);
        int nodesVisited = 0;
        if (startNode != null && endNode != null) {
            // create a queue to store the nodes
            Queue<Node> queue = new LinkedList<Node>();
            // create a set to store the visited nodes
            Set<Node> visited = new HashSet<Node>();
            // create a map to store the previous node
            Map<Node, Node> previous = new HashMap<Node, Node>();
            // add the start node to the queue
            queue.add(startNode);
            // add the start node to the visited set
            visited.add(startNode);
            // while the queue is not empty
            while (!queue.isEmpty()) {
                // remove the first node from the queue
                Node node = queue.remove();
                // if the node is the end node
                if (node.name.equals(endNode.name)) {
                    // create a stack to store the path
                    Stack<Node> path = new Stack<Node>();
                    // add the end node to the path
                    path.push(endNode);
                    // while the previous node is not null
                    while (previous.get(node) != null) {
                        // add the previous node to the path
                        path.push(previous.get(node));
                        // set the node to the previous node
                        node = previous.get(node);
                    }
                    // print the path
                    while (!path.isEmpty()) {
                        System.out.print(path.pop().name + " ");
                        nodesVisited++;
                    }
                    System.out.println();
                    return nodesVisited;
                }
                // for each edge in the node
                for (int i = 0; i < node.edges.length; i++) {
                    // if the edge is not null
                    if (node.edges[i] != null) {
                        // get the other node
                        Node otherNode = node.edges[i].getOtherNode(node);
                        // if the other node is not null and it has not been visited
                        if (otherNode != null && !visited.contains(otherNode)) {
                            // add the other node to the queue
                            queue.add(otherNode);
                            // add the other node to the visited set
                            visited.add(otherNode);
                            // add the other node to the previous map
                            previous.put(otherNode, node);
                        }
                    }
                }
            }
        }
        if (nodesVisited == 0) {
            System.out.println("No path found");
        }
        return nodesVisited;
    }

    public int cheapestPath(String startCity, String endCity) {
        Node startNode = getNode(startCity);
        Node endNode = getNode(endCity);
        int nodesVisited = 0;
        if (startNode != null && endNode != null) {
            // create a priority queue to store the nodes
            PriorityQueue<Node> queue = new PriorityQueue<Node>();
            // create a set to store the visited nodes
            Set<Node> visited = new HashSet<Node>();
            // create a map to store the previous node
            Map<Node, Node> previous = new HashMap<Node, Node>();
            // add the start node to the queue
            queue.add(startNode);
            // add the start node to the visited set
            visited.add(startNode);
            // while the queue is not empty
            while (!queue.isEmpty()) {
                // remove the first node from the queue
                Node node = queue.remove();
                // if the node is the end node
                if (node.name.equals(endNode.name)) {
                    // create a stack to store the path
                    Stack<Node> path = new Stack<Node>();
                    // add the end node to the path
                    path.push(endNode);
                    // while the previous node is not null
                    while (previous.get(node) != null) {
                        // add the previous node to the path
                        path.push(previous.get(node));
                        // set the node to the previous node
                        node = previous.get(node);
                    }
                    // print the path
                    while (!path.isEmpty()) {
                        System.out.print(path.pop().name + " ");
                        nodesVisited++;
                    }
                    System.out.println();
                    return nodesVisited;
                }
                // for each edge in the node
                for (int i = 0; i < node.edges.length; i++) {
                    // if the edge is not null
                    if (node.edges[i] != null) {
                        // get the other node
                        Node otherNode = node.edges[i].getOtherNode(node);
                        // if the other node is not null and it has not been visited
                        if (otherNode != null && !visited.contains(otherNode)) {
                            // add the other node to the queue
                            queue.add(otherNode);
                            // add the other node to the visited set
                            visited.add(otherNode);
                            // add the other node to the previous map
                            previous.put(otherNode, node);
                        }
                    }
                }
            }
        }
        if (nodesVisited == 0) {
            System.out.println("No path found");
        }
        return nodesVisited;
    }
}