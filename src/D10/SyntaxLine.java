package D10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SyntaxLine {

    String line;
    char corruptChar;
    int corruptCharValue;

    public SyntaxLine(String line) {
        this.line = line;
        corruptCharValue = 0;
    }

    public int isCorrupt() {
        isCorruptAux(line.toCharArray(), line.toCharArray()[0]);
        return corruptCharValue;
    }

    private int isCorruptAux(char[] arr, Character opener) {
        int res = -1;
        for (int i = 1; i < arr.length && res != 0; i++) {
            char temp = arr[i];
            if (temp == '(' || temp == '{' || temp == '[' || temp == '<') {
                res = isCorruptAux(Arrays.copyOfRange(arr, i, arr.length), temp);
                i += res;
            } else {
                if (opener == reverseBracket(temp)) {
                    return i;
                } else {
                    corruptChar = temp;
                    assignCorruptValue();
                    return 0;
                }
            }
        }
        return 0;
    }

    private void assignCorruptValue() {
        //    ): 3 points.
        //    ]: 57 points.
        //    }: 1197 points.
        //    >: 25137 points.
        switch (corruptChar) {
            case ')':
                corruptCharValue = 3;
                break;
            case ']':
                corruptCharValue = 57;
                break;
            case '}':
                corruptCharValue = 1197;
                break;
            case '>':
                corruptCharValue = 25137;
                break;
            default:
                break;
        }
    }

    private Character reverseBracket(Character bracket) {
        switch (bracket) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            case '>':
                return '<';
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            case '<':
                return '>';
            default:
                return null;
        }
    }

    public long completeLine() {
        List<BracketPair> bracketPairList = new ArrayList<>();
        char[] arr = line.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                bracketPairList.add(new BracketPair(c));
            } else {
                for (int i = bracketPairList.size() - 1; i >= 0; i--) {
                    if (bracketPairList.get(i).getRight() == null && bracketPairList.get(i).checkMatch(c)) {
                        bracketPairList.get(i).setRight(c);
                        break;
                    }
                }
            }
        }

        List<Character> toComplete = new ArrayList<>();
        for (int i = bracketPairList.size() - 1; i >= 0; i--) {
            BracketPair bracketPair = bracketPairList.get(i);
            if (bracketPair.getRight() == null) {
                toComplete.add(reverseBracket(bracketPair.getLeft()));
            }
        }
        return calculateScore(toComplete);
    }

    private long calculateScore(List<Character> toComplete) {
        long res = 0;
        for (Character character : toComplete) {
            res *= 5;
            res += bracketValue(character);
        }
        return res;
    }

    private int bracketValue(Character character) {
//    ): 1 point.
//    ]: 2 points.
//    }: 3 points.
//    >: 4 points.
        switch (character) {
            case ')':
                return 1;
            case ']':
                return 2;
            case '}':
                return 3;
            case '>':
                return 4;
            default:
                return 0;
        }
    }
}
