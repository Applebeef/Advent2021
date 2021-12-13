package D12;

import java.util.*;

public class Cave {
    private String name;
    private Set<Cave> children;
    private boolean isBig, visited;
    private int visits;

    public Cave(String name) {
        this.name = name;
        children = new HashSet<>();
        isBig = name.equals(name.toUpperCase());
        visited = false;
        visits = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        return Objects.equals(name, cave.name);
    }

    public boolean equals(String s) {
        return this.name.equals(s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void addChild(Cave cave) {
        children.add(cave);
    }

    public Set<Cave> getChildren() {
        return children;
    }

    public boolean isBig() {
        return isBig;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Set<List<Cave>> visit() {
        Set<List<Cave>> set = new HashSet<>();
        if (this.equals("end")) {
            List<Cave> list = new ArrayList<>();
            list.add(this);
            set.add(list);
            return set;
        }
        if (children.stream().allMatch(Cave::isVisited) && children.stream().noneMatch(Cave::isBig)) {
            return null;
        }

        setVisited(true);
        for (Cave cave : children) {
            if (cave.isBig() || !cave.isVisited()) {
                Set<List<Cave>> temp = cave.visit();
                if (temp != null) {
                    temp.forEach(l -> {
                        if (l != null) {
                            l.add(0, this);
                        }
                    });
                }
                if (temp != null) {
                    set.addAll(temp);
                }
            }
        }
        setVisited(false);
        return set;
    }

    public Set<List<Cave>> visit(boolean doubleVisitUsed) {
        Set<List<Cave>> set = new HashSet<>();
        if (this.equals("end")) {
            List<Cave> list = new ArrayList<>();
            list.add(this);
            set.add(list);
            return set;
        }
        if (children.stream().noneMatch(Cave::isBig) && (doubleVisitUsed && children.stream().allMatch(cave -> cave.getVisits() >= 1))) {
            return null;
        }
        setVisits(getVisits() + 1);
        doubleVisitUsed = doubleVisitUsed || (getVisits() == 2 && !isBig);
        for (Cave cave : children) {
            if (cave.isBig() || (cave.getVisits() == 0 && doubleVisitUsed) || (cave.getVisits() <= 1 && !doubleVisitUsed)) {
                if (!cave.equals("start")) {
                    Set<List<Cave>> temp;
                    temp = cave.visit(doubleVisitUsed);
                    if (temp != null) {
                        temp.forEach(l -> {
                            if (l != null) {
                                l.add(0, this);
                            }
                        });
                    }
                    if (temp != null) {
                        set.addAll(temp);
                    }
                }
            }
        }
        setVisits(getVisits() - 1);
        return set;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}
