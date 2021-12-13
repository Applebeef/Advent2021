package D2;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class D2 {

    private final File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D2\\input");

    public int Solve(Submarine submarine) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[] temp;
        while (scanner.hasNext()) {
            temp = scanner.nextLine().split(" ");
            try {
                submarine.getClass().getDeclaredMethod(temp[0], int.class).invoke(submarine, Integer.parseInt(temp[1]));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return submarine.getDepth() * submarine.getPosition();
    }
}
