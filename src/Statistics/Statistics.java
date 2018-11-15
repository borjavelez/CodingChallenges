package Statistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        for (String s = br.readLine(); s != null; s = br.readLine(), testCase++) {
            int[] stringNumbers = Arrays.stream(s.split(" ")).skip(1).mapToInt(Integer::parseInt).toArray();
            int min = Arrays.stream(stringNumbers).min().orElseThrow(NoSuchElementException::new);
            int max = Arrays.stream(stringNumbers).max().orElseThrow(NoSuchElementException::new);
            int difference = max - min;
            System.out.println("Case " + testCase + ": " + min + " " + max + " " + difference);
        }
    }
}
