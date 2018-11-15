package CalculatingDartScores;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatingDartScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> values = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
            values.put("single " + i, i);
            values.put("double " + i, i*2);
            values.put("triple " + i, i*3);
        }

        for (Map.Entry<String, Integer> m1 : values.entrySet()) {
            int firstValue = m1.getValue();
            if (firstValue == n) {System.out.println(m1.getKey()); return;}
            for (Map.Entry<String, Integer> m2 : values.entrySet()) {
                int secondValue = m2.getValue();
                int sum = firstValue + secondValue;
                if (sum == n) {
                    System.out.println(m1.getKey());
                    System.out.println(m2.getKey());
                    return;
                }
                else if (values.containsValue(n - sum)) {
                    System.out.println(m1.getKey());
                    System.out.println(m2.getKey());
                    System.out.println(values.entrySet().stream().filter(e -> e.getValue() == (n-sum)).findFirst().get().getKey());
                    return;
                }
            }
        }
        System.out.println("impossible");
    }
}
