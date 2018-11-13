package TourDeFrance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;


public class TourDeFrance {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(String s = bf.readLine(); s != null && !s.equals("0"); s = bf.readLine() ){
            String[] s1 = s.split(" ");
            int front = Integer.parseInt(s1[0]);
            int rear = Integer.parseInt(s1[1]);

            double[] front1 = new double[front];
            double[] rear2 = new double[rear];

            String[] readFront = bf.readLine().split(" ");
            String[] readRear = bf.readLine().split(" ");

            for (int i = 0; i < front; i++) {
                front1[i] = Double.parseDouble(readFront[i]);
            }
            for(int x = 0; x < rear; x++){
                rear2[x] = Double.parseDouble(readRear[x]);
            }

            SortedSet<Double> set = new TreeSet<>();
            for(int i = 0; i < front; i++){
                for(int x = 0; x < rear; x++){
                    set.add(rear2[x] / front1[i]);
                }
            }

            double result = 0;
            Iterator<Double> x = set.iterator();
            double previous = x.next();
            while (x.hasNext()) {
                double next = x.next();
                result = Math.max(result, next / previous);
                previous = next;
            }

            DecimalFormat df = new DecimalFormat("###.##");
            System.out.printf("%.2f%n", result);
        }
    }
}