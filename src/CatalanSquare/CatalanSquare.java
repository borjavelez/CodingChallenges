package CatalanSquare;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CatalanSquare {

    static Map<Long, BigInteger> mapFactorial = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(cal(scanner.nextInt() + 1));
    }

    //Returns (2n)!/((n+1)!*n!)
    public static BigInteger cal(long n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {
            BigInteger result = (factorial(2 * n)).divide(factorial(n + 1).multiply(factorial(n)));
            return result;
        }
    }

    //Returns the factorial of given number
    public static BigInteger factorial(long n) {
        if (mapFactorial.containsKey(n)) {
            return mapFactorial.get(n);
        } else {
            if (n <= 1) {
                return BigInteger.ONE;
            } else {
                BigInteger result = (factorial(n - 1).multiply(BigInteger.valueOf(n)));
                mapFactorial.put(n, result);
                return result;
            }
        }
    }
}
