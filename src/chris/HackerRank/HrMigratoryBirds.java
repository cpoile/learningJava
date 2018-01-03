package chris.HackerRank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HrMigratoryBirds {
    static int migratoryBirds(int n, int[] ar) {
        Map<Integer, Long> groups = IntStream.of(ar)
                .mapToObj(Integer::new)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long max = groups.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        int res = groups.entrySet().stream()
                .filter(kv -> kv.getValue() == max)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList()).get(0).getKey();
        return res;

        /*long maxVal = 0;
        int minKey = 0;
        for (Map.Entry kv : groups.entrySet()) {
            if ((Long)kv.getValue() > maxVal)
                maxVal = (Long)kv.getValue();
        }*/
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
