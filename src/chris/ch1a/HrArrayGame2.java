package chris.ch1a;

import java.io.FileInputStream;
import java.util.Scanner;

public class HrArrayGame2 {
    public static boolean canWin(int leap, int[] game) {
        return canWinFrom(leap, game, 0);
    }

    private static boolean canWinFrom(int leap, int[] game, int idx) {
        if (idx >= game.length)
            return true;
        if (idx < 0 || game[idx] == 1)
            return false;
        game[idx] = 1;
        return (canWinFrom(leap, game, idx + leap)
                || canWinFrom(leap, game, idx + 1)
                || canWinFrom(leap, game, idx - 1));
    }

    public static void main(boolean file) {

        try {
            Scanner scan = (file) ?
                    //new Scanner(new FileInputStream("HrArrayGame_input03.txt")) :
                    new Scanner(new FileInputStream("testinput2.txt")) :
                    new Scanner(System.in);
            int q = scan.nextInt();
            while (q-- > 0) {
                int n = scan.nextInt();
                int leap = scan.nextInt();

                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }

                System.out.println((canWin(leap, game)) ? "YES" : "NO");
            }
            scan.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

}
