package chris.HackerRank;

import java.util.Scanner;

public class HrIPPattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex {
    public String pattern = "^(\\d|\\d{2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|\\d{2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|\\d{2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|\\d{2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])";
}
