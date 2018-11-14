package GrassSeed;

import java.util.Scanner;

public class GrassSeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double costOfSeed = sc.nextDouble();
        int numberOfLawns = sc.nextInt();
        double sum = 0;
        for (int i = 0; i < numberOfLawns; i++) {
            double width = sc.nextDouble();
            double height = sc.nextDouble();
            sum += (width * height) * costOfSeed;
        }

        System.out.println(sum);
    }
}
