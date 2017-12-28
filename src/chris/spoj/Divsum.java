package chris.spoj;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Divsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<BigInteger> res = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int val = sc.nextInt();
            res.add(divisors(val));
        }

        res.forEach(System.out::println);
    }

    private static BigInteger divisors(int val) {
        int sqrt = (int) Math.sqrt(val) + 1;
        ArrayList<Integer> divisors = new ArrayList<>();
        if (val != 1)
            divisors.add(1);
        for (int i = 2; i < sqrt; i++) {
            if (val % i == 0) {
                divisors.add(i);
                if (i != val / i)
                    divisors.add(val / i);
            }
        }
        return divisors.stream().map(BigInteger::valueOf).reduce(BigInteger.ZERO, (x, y) -> x.add(y));
    }
}
