package StandOnZanzibar;

import java.util.Arrays;
import java.util.Scanner;

public class StandOnZanzibar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while (sc.hasNextLine()) {
            int counterImportTurtles = 0;
            String[] line = sc.nextLine().split(" ");
            int[] turtles = Arrays.stream(line).mapToInt(Integer::parseInt).filter(i -> i != 0).toArray();
            for (int i = 1; i < turtles.length; i++) {
                if (turtles[i] > turtles[i - 1] * 2)
                counterImportTurtles += turtles[i] - (turtles[i - 1] * 2);
            }
            System.out.println(counterImportTurtles);
        }
    }
}
