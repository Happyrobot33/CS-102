package Graph;

public class Edge implements Comparable<Edge> {
    Node node1;
    Node node2;
    private int price;

    public Edge(Node node1, Node node2, int price) {
        this.node1 = node1;
        this.node2 = node2;
        this.price = price;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public Node getOtherNode(Node node) {
        if (node1.name.equals(node.name)) {
            return node2;
        } else if (node2.name.equals(node.name)) {
            return node1;
        }
        return null;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Edge edge) {
        if (this.price < edge.price) {
            return -1;
        } else if (this.price > edge.price) {
            return 1;
        }
        return 0;
    }
}
