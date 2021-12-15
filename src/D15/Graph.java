package D15;

import D4.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private Node start, end;
    int size;
    PriorityQueue<Node> priorityQueue;

    /**
     * Constructor from 2 dimensional list of node weights, no diagonal movement allowed.
     * point at index (0, 0) becomes start and end is (n-1, m-1) where n and m are the lengths of the lists.
     *
     * @param twoDList 2 dimensional list of values
     */
    public Graph(List<List<Integer>> twoDList) {
        List<List<Node>> nodeList = new ArrayList<>();
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getDist));
        size = 0;
        for (List<Integer> list : twoDList) {
            size += list.size();
            List<Node> tempList = list.stream().map(Node::new).collect(Collectors.toList());
            nodeList.add(tempList);
            priorityQueue.addAll(tempList);
        }
        List<Pair<Integer, Integer>> deltas = initDeltas();
        start = nodeList.get(0).get(0);
        end = nodeList.get(nodeList.size() - 1).get(nodeList.get(nodeList.size() - 1).size() - 1);
        start.setDist(0);
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = 0; j < nodeList.get(i).size(); j++) {
                Node node = nodeList.get(i).get(j);
                for (Pair<Integer, Integer> delta : deltas) {
                    int newI = i + delta.getV1();
                    int newJ = j + delta.getV2();
                    if (newI >= 0 && newI < nodeList.size() && newJ >= 0 && newJ < nodeList.get(newI).size()) {
                        node.addChild(nodeList.get(newI).get(newJ));
                    }
                }
            }
        }
    }

    private List<Pair<Integer, Integer>> initDeltas() {
        List<Pair<Integer, Integer>> deltas = new ArrayList<>();
        for (int i = -1; i < 2; i += 2) {
            deltas.add(new Pair<>(i, 0));
            deltas.add(new Pair<>(0, i));
        }
        return deltas;
    }

    /**
     * Runs the Dijkstra algorithm from the node "start" to all other nodes.
     * The distance for each node is saved in Node.dist.
     */
    public void dijkstra() {
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            for (Node child : node.getChildren()) {
                if (priorityQueue.contains(child)) {
                    int newDist = node.getDist() + child.getWeight();
                    if (newDist < child.getDist()) {
                        priorityQueue.remove(child);
                        child.setDist(newDist);
                        child.setPrev(node);
                        priorityQueue.offer(child);
                    }
                }
            }
        }
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }
}
