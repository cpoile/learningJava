package chris.ch1a;

import java.util.ArrayList;
import java.util.Scanner;

public class HrEOF {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNext()) {
            lines.add(sc.nextLine());
        }
        int count = 0;
        for (String line : lines) {
            System.out.println(++count + " " + line);
        }
    }
}
