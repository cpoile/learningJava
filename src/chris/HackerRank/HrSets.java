package chris.HackerRank;

import java.io.*;
import java.util.*;

public class HrSets {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new FileInputStream("hrsets.txt"));
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {
            set.add(pair_left[i] + ", " + pair_right[i]);
            System.out.println(set.size());
        }
    }
}