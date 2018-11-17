package CombinationLock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationLock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (String s = br.readLine(); s != null && !s.equals("0 0 0 0"); s = br.readLine()) {
            //full turns
            int degrees = 1080;
            int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            //First number - clockwise
            degrees += findDegrees(numbers[0], numbers[1], true);

            //Second number - counter clockwise
            degrees += findDegrees(numbers[1], numbers[2], false);

            //Third number - clockwise
            degrees += findDegrees(numbers[2], numbers[3], true);

            System.out.println(degrees);
        }
    }

    private static int findDegrees (int pos1, int pos2, boolean clockwise) {
        int degrees = 0;
        if (clockwise) {
            degrees = pos1 < pos2 ? pos1 + (40 - pos2) : pos1 - pos2;
        } else {
            degrees = pos1 < pos2 ? pos2 - pos1 : 40 - (pos1 - pos2);
        }
        return degrees * (360 / 40);
    }
}
