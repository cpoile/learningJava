package chris.HackerRank;

import java.security.MessageDigest;
import java.util.Scanner;

public class HrSHA256 {
    public static void main(String[] argh) throws Exception {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] msgBytes = md.digest(msg.getBytes());
        for (byte b : msgBytes) {
            System.out.printf("%02x", b);
        }

    }
}
