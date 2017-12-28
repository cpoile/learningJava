package chris.HackerRank;

import java.io.FileInputStream;
import java.util.*;

public class HrDeque {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileInputStream("HrDeque.txt"));
        //Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int uniqueCount = 0;
        int maxUnique = 0;
        Map<Integer, Integer> uniqueMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer num = in.nextInt();

            if (deque.size() == m) {
                Integer elem = (Integer) deque.removeFirst();
                uniqueMap.merge(elem, -1, Integer::sum);
                if (uniqueMap.get(elem) == 0)
                    uniqueMap.remove(elem);
            }
            deque.addLast(num);
            //uniqueMap.put(num, uniqueMap.getOrDefault(num, 0) + 1);
            uniqueMap.merge(num, 1, Integer::sum);
            maxUnique = Math.max(maxUnique, uniqueMap.size());
        }

        System.out.println(maxUnique);
    }
}
