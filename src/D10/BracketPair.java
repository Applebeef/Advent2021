package D10;

public class BracketPair {
    private Character left, right;

    public BracketPair(char left, char right) {
        this.left = left;
        this.right = right;
    }

    public BracketPair(char left) {
        this.left = left;
        this.right = null;
    }

    public boolean checkMatch(char right) {
        return left == reverseBracket(right);
    }

    public Character getLeft() {
        return left;
    }

    public void setLeft(Character left) {
        this.left = left;
    }

    public Character getRight() {
        return right;
    }

    public void setRight(Character right) {
        this.right = right;
    }

    private Character reverseBracket(Character right) {
        switch (right) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            case '>':
                return '<';
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "left=" + left +
                ", right=" + right;
    }
}
