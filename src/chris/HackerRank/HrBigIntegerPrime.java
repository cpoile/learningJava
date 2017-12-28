package chris.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class HrBigIntegerPrime {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        BigInteger i = in.nextBigInteger();
        in.close();

        System.out.println(i.isProbablePrime(10) ? "prime" : "not prime");

    }
}
