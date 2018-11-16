package PrimePath;

import java.util.*;
import java.util.stream.Collectors;

public class PrimePath {
    static List<Integer> primeNumbers = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1000; i < 9999; i++) {
            if (isPrime(i)) primeNumbers.add(i);
        }

        for (int i = 0; i < testCases; i++) {
            int counter = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            //Number is the same
            if (x == y) {System.out.println(0); continue;}
            //Get the neighbors of X
            List<Integer> neighborsX = findNeighbors(x);
            //Keep track of visited numbers to avoid repetition
            List<Integer> visitedNumbers = neighborsX;
            counter++;
            while (!neighborsX.contains(y)) {
                //In case we have visited all the possible neighbors and we can't still find Y
                if (neighborsX.size() == 0) {
                    System.out.println("Impossible");
                    break;
                }

                Set<Integer> set = new HashSet<>();
                for (int n : neighborsX) {
                    List<Integer> t = findNeighbors(n).stream().filter(p -> !visitedNumbers.contains(p)).collect(Collectors.toList());
                    set.addAll(t);
                }
                neighborsX = new ArrayList<>(set);
                visitedNumbers.addAll(neighborsX);
                counter++;
            }
            System.out.println(counter);
        }
    }

    private static List<Integer> findNeighbors(int x) {
        List<Integer> neighbors = new ArrayList<>();
        int[] digits = Arrays.stream(String.valueOf(x).split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < digits.length; i++) {
            int y = digits[i];
            int[] temp = digits.clone();
            for (int j = 0; j <= 9; j++) {
                if (i == 0 && j == 0) continue;
                if (j != y) {
                    temp[i] = j;
                    StringBuilder append = new StringBuilder();
                    for (int z : temp) {
                        append.append(z);
                    }
                    neighbors.add(Integer.parseInt(append.toString()));
                }
            }
        }
        neighbors = neighbors.stream().filter(p -> primeNumbers.contains(p)).collect(Collectors.toList());
        return neighbors;
    }

    private static boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

