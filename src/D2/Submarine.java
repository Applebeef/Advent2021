package D2;

public class Submarine {
    private int position, depth;

    public Submarine() {
        position = depth = 0;
    }

    public void forward(int x) {
        position += x;
    }

    public void up(int x) {
        depth -= x;
    }

    public void down(int x) {
        depth += x;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
