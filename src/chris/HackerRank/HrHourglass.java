package chris.HackerRank;

public class HrHourglass {
    public static void GetBiggestSum() {
        int[][] arr = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 1, 2, 3},
                {4, 5, 6, 7, 8, 9},
                {1, 2, 3, 9, 9, 9},
                {7, 8, 9, 1, 9, 3},
                {4, 5, 6, 9, 9, 9}
        };

        int maxSum = Integer.MIN_VALUE;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                int sum = arr[r][c] + arr[r][c + 1] + arr[r][c + 2]
                        + arr[r + 1][c + 1]
                        + arr[r + 2][c] + arr[r + 2][c + 1] + arr[r + 2][c + 2];
                maxSum = Math.max(sum, maxSum);
            }
        }
        System.out.println(maxSum);
    }
}
