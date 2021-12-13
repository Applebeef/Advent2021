package D8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//  0:6      1:2      2:5      3:5      4:4
// aaaa    ....    aaaa    aaaa    ....
//b    c  .    c  .    c  .    c  b    c
//b    c  .    c  .    c  .    c  b    c
// ....    ....    dddd    dddd    dddd
//e    f  .    f  e    .  .    f  .    f
//e    f  .    f  e    .  .    f  .    f
// gggg    ....    gggg    gggg    ....
//
//  5:5      6:6      7:3      8:7      9:6
// aaaa    aaaa    aaaa    aaaa    aaaa
//b    .  b    .  .    c  b    c  b    c
//b    .  b    .  .    c  b    c  b    c
// dddd    dddd    ....    dddd    dddd
//.    f  e    f  .    f  e    f  .    f
//.    f  e    f  .    f  e    f  .    f
// gggg    gggg    ....    gggg    gggg

public class InputLine {
    List<String> numbers;
    List<String> results;
    String[] numbersArray;

    public InputLine(String[] arr) {
        numbersArray = new String[10];
        numbers = Arrays.stream(arr[0].split(" ")).collect(Collectors.toList());
        results = Arrays.stream(arr[1].split(" ")).collect(Collectors.toList());
        results.remove(0);
        numbersArray[1] = numbers.stream().filter(s -> s.length() == 2).findFirst().get();
        numbersArray[4] = numbers.stream().filter(s -> s.length() == 4).findFirst().get();
        numbersArray[7] = numbers.stream().filter(s -> s.length() == 3).findFirst().get();
        numbersArray[8] = numbers.stream().filter(s -> s.length() == 7).findFirst().get();

        List<Character> oneChars = stringToList(numbersArray[1]);
        List<Character> BD = numbersArray[4].chars().mapToObj(i -> (char) i).filter(character -> !oneChars.contains(character)).collect(Collectors.toList());
        find5Segments(BD);
        find6Segments(BD);
    }

    private void find5Segments(List<Character> bd) {
        //2,3,5
        List<String> fives = numbers.stream().filter(s -> s.length() == 5).collect(Collectors.toList());
        for (String str : fives) {
            List<Character> temp = stringToList(str);
            if (temp.containsAll(stringToList(numbersArray[1]))) {
                numbersArray[3] = str;
            } else if (temp.containsAll(bd)) {
                numbersArray[5] = str;
            } else {
                numbersArray[2] = str;
            }
        }
    }

    private void find6Segments(List<Character> bd) {
        //0,6,9
        List<String> sixes = numbers.stream().filter(s -> s.length() == 6).collect(Collectors.toList());
        for (String str : sixes) {
            List<Character> temp = stringToList(str);
            if (temp.containsAll(stringToList(numbersArray[4]))) {
                numbersArray[9] = str;
            } else if (temp.containsAll(bd)) {
                numbersArray[6] = str;
            } else {
                numbersArray[0] = str;
            }
        }

    }

    private List<Character> stringToList(String str) {
        return str.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
    }

    private Set<Character> stringToSet(String str) {
        return str.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
    }

    public int decodeOutput() {
        int[] res = new int[4];
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < numbersArray.length; j++) {
                if (stringToSet(results.get(i)).equals(stringToSet(numbersArray[j]))) {
                    res[i] = j;
                    break;
                }
            }
        }
        return (res[0] * 1000) + (res[1] * 100) + (res[2] * 10) + res[3];
    }
}
