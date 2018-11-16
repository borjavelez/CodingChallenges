package PrimaryArithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimaryArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (String s = br.readLine(); s != null && !s.equals("0 0"); s = br.readLine()) {
            String[] numbers = s.split(" ");
            int[] x = Arrays.stream(numbers[0].split("")).mapToInt(Integer::parseInt).toArray();
            int[] y = Arrays.stream(numbers[1].split("")).mapToInt(Integer::parseInt).toArray();

            if (x.length != y.length) {
                int[] smaller = x.length < y.length ? x : y;
                int[] bigger = x.length > y.length ? x : y;

                int[] temp = new int[bigger.length];
                Arrays.fill(temp, 0);
                for (int i = 1; i <= smaller.length; i++) {
                    temp[temp.length - i] = smaller[smaller.length - i];
                }
               if (smaller == x) x = temp;
               else y = temp;
            }

            int carryOperations = 0;
            for (int i = x.length - 1; i >= 0; i--) {
                if (x[i] + y[i] >= 10) {
                    carryOperations++;
                    if (i > 0) {
                        x[i - 1]++;
                    }
                }
            }

            if (carryOperations == 0) {
                System.out.println("No carry operation.");
            } else if (carryOperations == 1) {
                System.out.println("1 carry operation.");
            } else {
                System.out.println(carryOperations + " carry operations.");
            }

        }

    }
}
