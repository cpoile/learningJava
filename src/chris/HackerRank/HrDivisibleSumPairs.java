package chris.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class HrDivisibleSumPairs {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int numPairs = numberOfPairs(n, k, a);
        System.out.println(numPairs);
    }

    private static int numberOfPairs(int n, int k, int[] ar) {
        // rules: a_i + a_j is divisible by k
        int numPairs = 0;
        for (int a_i = 0; a_i < n - 1; a_i++) {
            for (int a_j = a_i + 1; a_j < n; a_j++) {
                if ((ar[a_i] + ar[a_j]) % k == 0)
                    numPairs++;
            }
        }
        return numPairs;
    }
}
