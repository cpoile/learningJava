package chris.HackerRank;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.*;

public class HrMiniMaxSum {
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long min = Arrays.stream(arr).asLongStream().limit(4).sum();
        long max = Arrays.stream(arr).asLongStream().skip(1).sum();
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) throws Exception {
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new FileInputStream("HrMiniMaxSum.txt"));
        int[] arr = new int[5];
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}
