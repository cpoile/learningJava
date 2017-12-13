package chris.ch1a;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HrPhoneNumMap {
    public static void main(String[] argh) {
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            phoneBook.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            Integer p = phoneBook.get(s);
            if (p == null)
                System.out.println("Not found");
            else
                System.out.println(s + "=" + p);
        }
    }
}
