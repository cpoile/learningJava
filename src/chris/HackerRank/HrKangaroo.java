package chris.HackerRank;

import java.util.Scanner;

public class HrKangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        // can we solve for: x1 + v1t = x2 + v2t, for an even value of t
        // x1-x2 = v2t - v1t, x1-x2 = t(v2-v1), (x1-x2)/(v2-v1) = t
        if (x1 == x2)
            return "YES";
        if (v2 == v1)
            return "NO";
        return ((x1 - x2) % (v2 - v1) == 0 && (x1 - x2) / (v2 - v1) > 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
