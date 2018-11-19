package SecretSanta;

import java.io.InputStreamReader;
import java.util.*;

public class SecretSanta {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n;
        try {
            n = sc.nextInt();
        } catch (InputMismatchException ime) {
            //The input can be a BigInteger
            n = 9;
        }

        /*
        According to The Montmort's Matchin Problem, the result will always tend to 1/e
        This means, that every time N is greater than 8, the first 6 decimals will be the same
        So we can just calculate the value when the n is 9
         */
        if (n > 8) n = 9;

        String s = "";
        for (int i = 1; i <= n; i++) {
            s = s + String.valueOf(i);
        }
        Set<String> combinations = permutation("", s.toString(), new HashSet<>());

        long validCombinations = 0;
        for (String combination : combinations) {
            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                isValid = (combination.charAt(i) != (char) (i + '1')) && isValid;
            }
            if (isValid) validCombinations++;
        }
        double result = 1.0 - ((double) validCombinations / (double) combinations.size());
        System.out.printf("%.6f%n", result);
    }

    //I send the Set so it can be populated recursively.
    private static Set<String> permutation(String prefix, String str, Set<String> combinations) {
        int n = str.length();
        if (n == 0) combinations.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), combinations);
        }
        return combinations;
    }

}
