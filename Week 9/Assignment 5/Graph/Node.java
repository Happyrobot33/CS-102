package Graph;
import Graph.Node;

//create a node class
public class Node implements Comparable<Node> {
    String name;
    Node[] connections = new Node[0];
    Edge[] edges = new Edge[0];

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEdge(Node node, int price) {
        // add the node to the connections array
        Node[] temp = new Node[connections.length + 1];
        for (int i = 0; i < connections.length; i++) {
            temp[i] = connections[i];
        }
        temp[temp.length - 1] = node;
        connections = temp;

        // add the edge to the edges array
        Edge[] temp2 = new Edge[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            temp2[i] = edges[i];
        }
        temp2[temp2.length - 1] = new Edge(this, node, price);
        edges = temp2;
    }

    public Node[] getConnections() {
        return connections;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public int getEdgePrice(Node node) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].getNode1() == node || edges[i].getNode2() == node) {
                return edges[i].getPrice();
            }
        }
        return -1;
    }

    public boolean isConnected(Node node) {
        for (int i = 0; i < connections.length; i++) {
            if (connections[i] == node) {
                return true;
            }
        }
        return false;
    }

    public void printConnections() {
        for (int i = 0; i < connections.length; i++) {
            System.out.print(connections[i].getName() + " ");
        }
    }

    public void printEdges() {
        for (int i = 0; i < edges.length; i++) {
            System.out.print(edges[i].getNode1().getName() + "-" + edges[i].getNode2().getName() + " ");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Node node) {
        return name.compareTo(node.name);
    }
}