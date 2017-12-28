package chris.HackerRank;

import java.io.FileInputStream;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class HrBitSet2 {
    public static void main(String[] argh) throws Exception {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("HrBitSet2.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet[] bsets = {new BitSet(n), new BitSet(n)};

        Map<String, BiConsumer<Integer, Integer>> ops = new HashMap<>();
        ops.put("AND", (x, y) -> bsets[x - 1].and(bsets[y - 1]));
        ops.put("OR", (x, y) -> bsets[x - 1].or(bsets[y - 1]));
        ops.put("XOR", (x, y) -> bsets[x - 1].xor(bsets[y - 1]));
        ops.put("FLIP", (x, y) -> bsets[x - 1].flip(y));
        ops.put("SET", (x, y) -> bsets[x - 1].set(y));

        for (int i = 0; i < m; i++) {
            String op = sc.next();
            int arg1 = sc.nextInt();
            int arg2 = sc.nextInt();
            ops.get(op).accept(arg1, arg2);
            System.out.println(bsets[0].cardinality() + " " + bsets[1].cardinality());
        }
    }
}
