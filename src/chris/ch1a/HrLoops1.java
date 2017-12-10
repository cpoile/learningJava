package chris.ch1a;

import java.util.Scanner;

public class HrLoops1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(input + " x " + i + " = " + input * i);
        }
    }
}
