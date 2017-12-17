package chris.ch1a;

import java.util.Scanner;

public class HrPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= A.length(); i++) {
            sb.append(A.charAt(A.length() - i));
        }
        System.out.println((A.compareTo(sb.toString()) == 0) ? "Yes" : "No");
    }
}
