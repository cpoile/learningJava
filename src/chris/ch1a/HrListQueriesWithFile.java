package chris.ch1a;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HrListQueriesWithFile {
    public static void main(boolean file) {
        Scanner sc;
        try {
            sc = (file) ? new Scanner(new FileInputStream("testListQueries.txt"))
                    : new Scanner(System.in);
            int size = sc.nextInt();
            List<Integer> lst = new ArrayList<>();
            while (size-- > 0) {
                lst.add(sc.nextInt());
            }

            int numQ = sc.nextInt();
            while (numQ-- > 0) {
                // trow away newline
                sc.nextLine();

                String cmd = sc.nextLine();
                switch (cmd) {
                    case "Insert":
                        insertNextTwo(lst, sc);
                        break;
                    case "Delete":
                        delete(lst, sc);
                        break;
                }
            }
            System.out.print(String.join(" ", lst.stream().map(i -> i.toString()).collect(Collectors.toList())));

        } catch (Exception e) {

        }


    }

    private static void delete(List<Integer> lst, Scanner sc) {
        int idx = sc.nextInt();
        lst.remove(idx);
    }

    private static void insertNextTwo(List<Integer> lst, Scanner sc) {
        int idx = sc.nextInt();
        int elem = sc.nextInt();
        lst.add(idx, elem);
    }
}
