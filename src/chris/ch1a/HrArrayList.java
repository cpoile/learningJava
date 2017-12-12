package chris.ch1a;

import java.util.ArrayList;
import java.util.Scanner;

public class HrArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numArrays = sc.nextInt();
        ArrayList<ArrayList<Integer>> arrOfArrs = new ArrayList<>();
        for (int i = 0; i < numArrays; i++) {
            int numElems = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < numElems; j++)
                arr.add(sc.nextInt());
            arrOfArrs.add(arr);
        }

        System.out.println(arrOfArrs);

        // Handle queries
        int numQueries = sc.nextInt();
        for (int i = 0; i < numQueries; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            try {
                System.out.println(arrOfArrs.get(x - 1).get(y - 1));
            } catch (java.lang.Exception e) {
                System.out.println("ERROR!");
            }
        }

    }
}
