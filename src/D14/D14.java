package D14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class D14 {
    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D14\\input");

    public long Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Map<String, String> polymerInsertionMap = new HashMap<>();
        String polymer = scanner.nextLine().trim();
        List<Character> polymerAsList = polymer.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().trim().split(" -> ");
            polymerInsertionMap.put(split[0], split[1]);
        }

        for (int j = 0; j < 10; j++) {
            int added = 0;
            for (int i = 0; i < polymer.length() - 1; i++) {
                String temp = new String(polymer.toCharArray(), i, 2);
                String toInsert = polymerInsertionMap.get(temp);
                polymerAsList.add(i + added + 1, toInsert.charAt(0));
                added++;
            }
            polymer = listToString(polymerAsList);
            polymerAsList = polymer.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character character : polymerAsList) {
            if (countMap.containsKey(character)) {
                countMap.put(character, countMap.get(character) + 1);
            } else {
                countMap.put(character, 1);
            }
        }
        int max = countMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        int min = countMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
        return max - min;
    }

    private String listToString(List<Character> list) {
        char[] arr = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return new String(arr);
    }

    public long Solve2(int steps) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String polymer = scanner.nextLine();
        scanner.nextLine();
        Map<String, String> polymerInsertionMap = new HashMap<>();
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().trim().split(" -> ");
            polymerInsertionMap.put(split[0], split[1]);
        }
        Map<String, Long> charCount = new HashMap<>();
        Map<String, Long> duoCount = new HashMap<>();
        for (int i = 0; i < polymer.length(); i++) {
            if (i < polymer.length() - 1) {
                duoCount.put(polymer.substring(i, i + 2), 1L);
            }

            String singleChar = polymer.substring(i, i + 1);
            if (charCount.containsKey(singleChar)) {
                charCount.put(singleChar, charCount.get(singleChar) + 1);
            } else {
                charCount.put(singleChar, 1L);
            }
        }

        for (int i = 0; i < steps; i++) {
            Map<String, Long> duoChange = new HashMap<>();
            for (String str : polymerInsertionMap.keySet()) {
                duoChange.put(str, 0L);
            }

            for (Map.Entry<String, Long> entry : duoCount.entrySet()) {
                long amount = entry.getValue();
                duoCount.put(entry.getKey(), 0L);
                String insert = polymerInsertionMap.get(entry.getKey());
                String res1, res2;
                res1 = entry.getKey().substring(0, 1);
                res2 = entry.getKey().substring(1, 2);
                duoChange.put(res1 + insert, duoChange.get(res1 + insert) + amount);
                duoChange.put(insert + res2, duoChange.get(insert + res2) + amount);
                if (charCount.containsKey(insert)) {
                    charCount.put(insert, charCount.get(insert) + amount);
                } else {
                    charCount.put(insert, amount);
                }
            }
            duoCount.putAll(duoChange);
        }
        long max = charCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        long min = charCount.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
        return max - min;
    }
}
