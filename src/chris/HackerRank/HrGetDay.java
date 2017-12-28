package chris.HackerRank;

import java.time.LocalDate;


public class HrGetDay {
    public static String getDay(String day, String month, String year) {
        LocalDate ld = LocalDate.of(
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(day));
        return ld.getDayOfWeek().toString();
    }
}
