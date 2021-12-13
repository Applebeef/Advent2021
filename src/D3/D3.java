package D3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D3 {

    private final File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D3\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();
        int[] arr = new int[str.length()];
        char[] res1 = new char[str.length()];
        char[] res2 = new char[str.length()];
        Arrays.fill(arr, 0);

        int total = 0;
        do {
            total++;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '1') {
                    arr[i]++;
                }
            }
            str = scanner.nextLine();
        } while (scanner.hasNextLine());

        for (int i = 0; i < res1.length; i++) {
            if (arr[i] >= total / 2) {
                res1[i] = '1';
                res2[i] = '0';
            } else {
                res1[i] = '0';
                res2[i] = '1';
            }
        }

        return Integer.parseInt(String.valueOf(res1), 2) * Integer.parseInt(String.valueOf(res2), 2);
    }

    public int Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();
        int[] arr = new int[str.length()];
        Arrays.fill(arr, 0);
        List<String> input = new ArrayList<>();

        do {
            input.add(str);
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '1') {
                    arr[i]++;
                }
            }
            str = scanner.nextLine();
        } while (scanner.hasNextLine());
        input.add(str);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '1') {
                arr[i]++;
            }
        }

        String res1 = filterStrings(str.length(), arr, input, true);
        String res2 = filterStrings(str.length(), arr, input, false);

        return Integer.parseInt(res1, 2) * Integer.parseInt(res2, 2);
    }

    private String filterStrings(int length, int[] arr, List<String> tmp, boolean OG) {
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < length && tmp.size() != 1; i++) {
            char test = arr2[i] >= (tmp.size() - arr2[i]) ? '1' : '0';
            if (!OG) {
                test = test == '1' ? '0' : '1';
            }
            int finalI = i;
            char finalTest = test;
            tmp = tmp.stream().filter(s -> s.charAt(finalI) == finalTest).collect(Collectors.toList());

            Arrays.fill(arr2, 0);
            tmp.forEach(s -> {
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (c == '1') {
                        arr2[j]++;
                    }
                }
            });

        }
        return tmp.get(0);
    }


}
