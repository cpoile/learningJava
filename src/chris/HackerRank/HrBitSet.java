package chris.HackerRank;

import java.util.BitSet;
import java.util.Scanner;
import java.util.function.Consumer;

public class HrBitSet {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String op = sc.next();
            int arg1 = sc.nextInt();
            int arg2 = sc.nextInt();
            BitSet l, r;

            if (arg1 == 1) {
                l = b1;
                r = b2;
            } else {
                l = b2;
                r = b1;
            }
            switch (op) {
                case "AND":
                    l.and(r);
                    break;
                case "OR":
                    l.or(r);
                    break;
                case "XOR":
                    l.xor(r);
                    break;
                case "FLIP":
                    l.flip(arg2);
                    break;
                case "SET":
                    l.set(arg2);
                    break;
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
    }
}
