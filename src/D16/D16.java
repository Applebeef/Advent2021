package D16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D16 {
    private File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D16\\input");
    private Packet packet;

    public D16() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String input = scanner.nextLine();
        char[] arr = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(String.format("%04d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(String.format("%c", arr[i]), 16)))));
        }
        packet = new Packet(stringBuilder.toString(), true);
    }

    public int Solve1() {
        return packet.VersionSum();
    }

    public long Solve2() {
        return packet.getValue();
    }
}
