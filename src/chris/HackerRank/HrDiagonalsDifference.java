package chris.HackerRank;

import java.util.Scanner;

public class HrDiagonalsDifference {
    static int diagonalDifference(int[][] a) {
        // top right to bot left is +1 +1, +1 +1, etc. starting from 0, 0
        // top left to bot right is -1 +1, -1, +1, etc. starting from n-1, 0
        int n = a[0].length;
        int right = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            right += a[i][i];
            left += a[i][n - 1 - i];
        }
        return Math.abs(right - left);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
