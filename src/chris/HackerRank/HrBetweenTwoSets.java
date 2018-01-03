package chris.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HrBetweenTwoSets {
    static public void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(b);
        Arrays.sort(a);
        int minB = b[0];
        int maxA = a[a.length - 1];
        int numXsBetweenTwoSets = 0;

        // x has to be >= maxA and <= minB
        for (int x = maxA; x <= minB; x++) {
            //can x be evenly divided by each of a?
            boolean xEvenlyDivByA = true;
            for (int a_i : a) {
                if (x % a_i != 0) {
                    xEvenlyDivByA = false;
                    break;
                }
            }
            if (xEvenlyDivByA) {
                // is x a factor of each b?
                boolean xFactorOfEachB = true;
                for (int b_i : b) {
                    if (b_i % x != 0) {
                        xFactorOfEachB = false;
                        break;
                    }
                }
                if (xFactorOfEachB)
                    numXsBetweenTwoSets++;
            }
        }
        System.out.println(numXsBetweenTwoSets);
    }
}
