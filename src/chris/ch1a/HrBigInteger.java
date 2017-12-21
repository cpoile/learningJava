package chris.ch1a;

import java.math.BigInteger;
import java.util.Scanner;

public class HrBigInteger {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        BigInteger a = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
