package chris.HackerRank;

import java.util.Scanner;

public class HrSubArrays {
    public static void GetNumNegSubArrays() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] oarr = new int[num];
        for (int i = 0; i < num; i++)
            oarr[i] = sc.nextInt();

        int countOfNegs = 0;
        for (int subArrLength = 1; subArrLength <= oarr.length; subArrLength++) {
            for (int subArrIdx = 0; subArrIdx < (oarr.length - subArrLength + 1); subArrIdx++) {
                int[] subArr = java.util.Arrays.copyOfRange(oarr, subArrIdx, subArrIdx + subArrLength);
                int sum = java.util.Arrays.stream(subArr).reduce(0, Integer::sum);
                if (sum < 0) countOfNegs++;
            }
        }
        System.out.println(countOfNegs);
    }
}
