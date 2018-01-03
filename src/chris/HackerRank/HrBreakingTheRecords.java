package chris.HackerRank;

import java.util.Scanner;

public class HrBreakingTheRecords {
    static public void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nMaxBroken = 0;
        int nMinBroken = 0;
        int max, min;
        max = min = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int next = sc.nextInt();
            if (next > max) {
                max = next;
                nMaxBroken++;
            } else if (next < min) {
                min = next;
                nMinBroken++;
            }
        }
        System.out.println(nMaxBroken + " " + nMinBroken);
    }
}
