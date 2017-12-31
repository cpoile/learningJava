package chris.HackerRank;

import java.util.Scanner;
import java.util.stream.IntStream;

public class HrAppleAndOrange {
    static int[] appleAndOrange(int s, int t, int a, int b, int[] apple, int[] orange) {
//        int[] ret = new int[2];
//        for (int i : apple) {
//            if (a+i >= s && a+i <= t)
//                ret[0]++;
//        }
//        for (int i : orange) {
//            if (b+i >= s && b+i <= t)
//                ret[1]++;
//        }

        int[] ret = new int[2];
        ret[0] = (int) IntStream.of(apple).filter(v -> a + v >= s && a + v <= t).count();
        ret[1] = (int) IntStream.of(orange).filter(v -> b + v >= s && b + v <= t).count();

        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in.nextInt();
        }
        int[] result = appleAndOrange(s, t, a, b, apple, orange);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
