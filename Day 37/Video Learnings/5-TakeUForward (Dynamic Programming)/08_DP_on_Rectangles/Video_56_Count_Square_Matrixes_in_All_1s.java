
public class Video_56_Count_Square_Matrixes_in_All_1s {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 1, 0 },
                { 1, 1, 1 },
                { 1, 1, 0 }
        };
        int ans = getCount(arr);
        System.out.println(ans);
    }

    public static int getCount(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (arr[i][j] == 1) {
                        dp[i][j] = 1;
                    }
                    if (i >= 1 && i < arr.length && j >= 1 && j < arr[i].length) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                sum += dp[i][j];
            }
        }

        return sum;
    }
}

/*
 * Note---> In all king of rectangular matrixes we tend to use tabulation
 * approach...
 */
