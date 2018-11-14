package BasicRemains;

import java.math.BigInteger;
import java.util.Scanner;

public class BasicRemains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(String s = sc.nextLine(); s != null && !s.equals("0"); s = sc.nextLine()){
            String[] numbers = s.split(" ");
            int base = Integer.parseInt(numbers[0]);
            BigInteger p = new BigInteger(numbers[1], base);
            BigInteger m = new BigInteger(numbers[2], base);

            System.out.println(p.mod(m).toString(base));
        }
    }
}
