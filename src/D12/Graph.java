package D12;

import java.util.*;

public class Graph {
    private Cave start, end;
    private Map<String, Cave> caves;

    public Graph() {
        start = new Cave("start");
        end = new Cave("end");
        caves = new HashMap<>();
        caves.put(start.getName(), start);
        caves.put(end.getName(), end);
    }

    public void addPath(String[] path) {
        Cave left, right;
        left = caves.containsKey(path[0]) ? caves.get(path[0]) : new Cave(path[0]);
        right = caves.containsKey(path[1]) ? caves.get(path[1]) : new Cave(path[1]);
        caves.put(left.getName(), left);
        caves.put(right.getName(), right);

        left.addChild(right);
        right.addChild(left);
    }

    public Set<List<Cave>> getPaths() {
        return start.visit();
    }

    public Set<List<Cave>> getPaths2Visits() {
        return start.visit(false);
    }
}
