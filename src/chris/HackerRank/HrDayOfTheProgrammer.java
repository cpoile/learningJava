package chris.HackerRank;

import java.util.Scanner;

public class HrDayOfTheProgrammer {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        String dayOfProg = getDay(year);
    }

    private static String getDay(int year) {
        // 1918 is a special case: Feb 14th was the 32nd day of the year
        if (year == 1918)
            return "";
        return "";
    }
}
