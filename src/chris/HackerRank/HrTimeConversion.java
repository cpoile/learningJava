package chris.HackerRank;

import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HrTimeConversion {
    static String timeConversion(String s) {
        Pattern pattern = Pattern.compile("([0-9]{2})(:[0-9]{2}:[0-9]{2})([A|PM]{2})");
        Matcher time = pattern.matcher(s);
        time.matches();
        int hr = Integer.parseInt(time.group(1));
        if ("PM".equals(time.group(3)) && hr != 12)
            hr += 12;
        else if ("AM".equals(time.group(3)) && hr == 12)
            hr = 0;
        return String.format("%02d%s", hr, time.group(2));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
