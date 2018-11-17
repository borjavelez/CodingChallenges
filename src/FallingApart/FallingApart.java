package FallingApart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FallingApart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPieces = sc.nextInt();
        List<Integer> pieces = IntStream.range(0, numberOfPieces)
                .map(i -> sc.nextInt())
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> alice = new ArrayList<>();
        List<Integer> bob = new ArrayList<>();

        boolean alicesPick = true;
        for (int i : pieces) {
            if (alicesPick) {
                alice.add(i);
                alicesPick = false;
            } else {
                bob.add(i);
                alicesPick = true;
            }
        }

        System.out.println(alice.stream().mapToInt(Integer::intValue).sum() + " " +
                bob.stream().mapToInt(Integer::intValue).sum());

    }
}
