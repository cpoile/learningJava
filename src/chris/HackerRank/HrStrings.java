package chris.HackerRank;

import java.util.Scanner;

public class HrStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        int lengths = A.length() + B.length();

        // doing this algorithmically cause it's more learning.
        // if they are the same up to the length of the shortest, then B is before A?
        boolean bBeforeA = true;
        int minLength = Math.min(A.length(), B.length());
        for (int i = 0; i < minLength; i++) {
            if (B.charAt(i) < A.charAt(i)) {
                bBeforeA = true;
                break;
            } else if (B.charAt(i) > A.charAt(i)) {
                bBeforeA = false;
                break;
            } else if (B.length() == minLength) {
                if (B.length() == A.length())
                    bBeforeA = false;
                else
                    bBeforeA = true;
            } else if (A.length() == minLength) {
                bBeforeA = false;
            }
        }

        String cappedA = A.substring(0, 1).toUpperCase() + A.substring(1);
        String cappedB = B.substring(0, 1).toUpperCase() + B.substring(1);

        System.out.println(lengths);
        System.out.println((bBeforeA) ? "Yes" : "No");
        System.out.println(cappedA + " " + cappedB);
    }
}
