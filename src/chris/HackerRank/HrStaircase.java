package chris.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class HrStaircase {
    static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            char[] left = new char[n - (i + 1)];
            char[] right = new char[i + 1];
            Arrays.fill(left, ' ');
            Arrays.fill(right, '#');
            System.out.println(new String(left) + new String(right));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}
