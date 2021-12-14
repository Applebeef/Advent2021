package D6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D6 {
    private final File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D6\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();
        List<Fish> fishList = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().map(Fish::new).collect(Collectors.toList());
        List<Fish> newFish = new ArrayList<>();

        for (int i = 0; i < 80; i++) {
            for (Fish fish : fishList) {
                Fish tempFish = fish.reduceAge();
                if (tempFish != null) {
                    newFish.add(tempFish);
                }
            }
            fishList.addAll(newFish);
            newFish.clear();
        }

        return fishList.size();
    }

    public long Solve2(int days) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        long[] fishBuckets = new long[9];
        long[] tempFishBuckets = new long[9];
        Arrays.fill(fishBuckets, 0);
        Arrays.fill(tempFishBuckets, 0);
        String str = scanner.nextLine();
        Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).forEach(age -> fishBuckets[age]++);

        long amount;
        for (int i = 0; i < days; i++) {
            for (int j = tempFishBuckets.length - 1; j >= 0; j--) {
                amount = fishBuckets[j];
                fishBuckets[j] = 0;
                if (j != 0) {
                    tempFishBuckets[j - 1] += amount;
                } else {
                    tempFishBuckets[6] += amount;
                    tempFishBuckets[8] += amount;
                }
            }
            System.arraycopy(tempFishBuckets, 0, fishBuckets, 0, tempFishBuckets.length);
            Arrays.fill(tempFishBuckets, 0);
        }

        long res = 0;
        for (long l : fishBuckets) {
            res += l;
        }
        return res;
    }
}
