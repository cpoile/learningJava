package chris.ch1a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HrSubstrings {
    public static String getSmallestAndLargest(String s, int k) {
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        int numSubstrings = s.length() - k + 1;
        List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < numSubstrings; i++) {
            subStrings.add(s.substring(i, i + k));
        }
        subStrings.sort(String::compareTo);

        return subStrings.get(0) + "\n" + subStrings.get(numSubstrings - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
