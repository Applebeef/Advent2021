package D15;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int weight;
    private List<Node> children;
    private int dist;
    private Node prev;

    public Node(int weight) {
        this.weight = weight;
        children = new ArrayList<>();
        dist = Integer.MAX_VALUE;
        prev = null;
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public int getWeight() {
        return weight;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return String.valueOf(dist);
    }
}
