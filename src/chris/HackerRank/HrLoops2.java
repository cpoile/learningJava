package chris.HackerRank;

import java.util.Scanner;

public class HrLoops2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();

            for (int j = 0; j < n; j++)
                System.out.print(a + recSeries(b, j, 0) + " ");
            System.out.println();
        }
        sc.close();
    }

    private static int recSeries(int b, int n, int accum) {
        if (n < 0)
            return accum;
        else {
            // TODO: not sure why the following doesn't work, like it should
            // return recSeries(b, --n, ((int)Math.pow(2, n) * b) + accum);

            int next = (int) Math.pow(2, n) * b + accum;
            return recSeries(b, --n, next);
        }
    }
}
