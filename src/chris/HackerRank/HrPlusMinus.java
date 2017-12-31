package chris.HackerRank;

import java.util.Scanner;
import java.util.stream.IntStream;

public class HrPlusMinus {
    static void plusMinus(int[] arr) {
        double n = arr.length;
        long pos = IntStream.of(arr).filter(x -> x > 0).count();
        long neg = IntStream.of(arr).filter(x -> x < 0).count();
        long zero = IntStream.of(arr).filter(x -> x == 0).count();
        System.out.printf("%1.6f\n", pos / n);
        System.out.printf("%1.6f\n", neg / n);
        System.out.printf("%1.6f\n", zero / n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
