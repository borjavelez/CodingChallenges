package QALY;

import java.util.Locale;
import java.util.Scanner;

public class QALY {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);;
        int testCases = sc.nextInt();
        double qalyValue = 0;
        do {
            double qualityOfLife = sc.nextDouble();
            double years = sc.nextDouble();
            qalyValue += qualityOfLife * years;
            testCases--;
        } while (testCases != 0);
        System.out.println(qalyValue);
    }
}
