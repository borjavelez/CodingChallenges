package TrollHunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrollHunt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int stoneBridges = Integer.parseInt(line[0]);
        int totalKnights = Integer.parseInt(line[1]);
        int knightsPerGroup = Integer.parseInt(line[2]);

        stoneBridges--;
        int expeditions = totalKnights/knightsPerGroup;
        int days = stoneBridges / expeditions;
        days += stoneBridges % expeditions > 0 ? 1 : 0;

        System.out.println(days);
    }
}
