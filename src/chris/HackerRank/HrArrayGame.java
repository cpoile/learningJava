package chris.HackerRank;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class HrArrayGame {
    public static boolean canWin(int leap, int[] game) {
        int[] emptyTriedFrom = new int[game.length];
//        return canWinFrom(0, leap, game, emptyTriedFrom);

        try {
            return canWinFrom(0, leap, game, emptyTriedFrom);
        } catch (Exception e) {
            System.out.println("exception for game: " + Arrays.toString(game));
            return false;
        }
    }

    private static boolean canWinFrom(int idx, int leap, int[] game, int[] triedFrom) {
        // four possible moves at each stage: jump right, step right, step left

        // have we tried from this spot yet? if so, then we can't win from it.
        if (triedFrom[idx] == 1)
            return false;
        else
            triedFrom[idx] = 1;

        // did we win?
        if (idx == game.length - 1 || idx + leap >= game.length)
            return true;
        // can we leap? If so, leap.
        if (game[idx + leap] == 0 && canWinFrom(idx + leap, leap, game, triedFrom))
            return true;
        // can't win from leaping, so try to win by stepping
        if (game[idx + 1] == 0 && canWinFrom(idx + 1, leap, game, triedFrom))
            return true;
        // can't win from stepping, so try to win by going back and trying again
        if (idx > 0 && game[idx - 1] == 0 && canWinFrom(idx - 1, leap, game, triedFrom))
            return true;
        return false;
    }

    public static void main(boolean file) {

        try {
            Scanner scan = (file) ?
                    //new Scanner(new FileInputStream("HrArrayGame_input03.txt")) :
                    new Scanner(new FileInputStream("testinput.txt")) :
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
