//Using Recursion
public class Video9_Maze_Obstacles {
    public static void main(String[] args) {
        int[][] arr = {
                { 0, 0, 0, 0, 0 },
                { 0, -1, 0, -1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, -1, 0, 0, 0 },
                { 0, 0, 0, -1, 0 }
        };

        int ans = getAllPaths(arr, 0, 0);
        System.out.println(ans);
    }

    public static int getAllPaths(int[][] arr, int rowStart, int colStart) {
        if (rowStart == arr.length - 1 && colStart == arr.length - 1) {
            return 1;
        }
        if (rowStart >= arr.length || colStart >= arr.length) {
            return 0;
        }

        int ans1 = 0;
        int ans2 = 0;
        if (colStart < arr.length - 1 && arr[rowStart][colStart + 1] != -1) {
            ans2 = getAllPaths(arr, rowStart, colStart + 1);
        }
        if (rowStart < arr.length - 1 && arr[rowStart + 1][colStart] != -1) {
            ans1 = getAllPaths(arr, rowStart + 1, colStart);
        }
        return ans1 + ans2;
    }
}

// ___________________________________________________________
// Using Memoization
import java.util.*;
public class Video9_Maze_Obstacles {
    public static void main(String[] args) {
        int[][] arr = {
                { 0, 0, 0, 0, 0 },
                { 0, -1, 0, -1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, -1, 0, 0, 0 },
                { 0, 0, 0, -1, 0 }
        };

        int[][] dp = new int[arr.length][arr[0].length];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }

        int ans = getAllPaths(arr, 0, 0, dp);
        System.out.println(ans);
    }

    public static int getAllPaths(int[][] arr, int rowStart, int colStart, int[][] dp) {
        if (rowStart == arr.length - 1 && colStart == arr.length - 1) {
            return 1;
        }
        if (rowStart >= arr.length || colStart >= arr.length) {
            return 0;
        }
        if(dp[rowStart][colStart] != -1){
            return dp[rowStart][colStart];
        }

        int ans1 = 0;
        int ans2 = 0;
        if (colStart < arr.length - 1 && arr[rowStart][colStart + 1] != -1) {
            ans2 = getAllPaths(arr, rowStart, colStart + 1, dp);
        }
        if (rowStart < arr.length - 1 && arr[rowStart + 1][colStart] != -1) {
            ans1 = getAllPaths(arr, rowStart + 1, colStart, dp);
        }
        return dp[rowStart][colStart] = ans1 + ans2;
    }
}

// ___________________________________________________________
// Using Tabulation

public class Video9_Maze_Obstacles {
    public static void main(String[] args) {
        int[][] arr = {
                { 0, 0, 0, 0, 0 },
                { 0, -1, 0, -1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, -1, 0, 0, 0 },
                { 0, 0, 0, -1, 0 }
        };

        int ans = getAllPaths(arr, 0, 0);
        System.out.println(ans);
    }

    public static int getAllPaths(int[][] arr, int rowStart, int colStart) {
        int[][] dp = new int[arr.length][arr[0].length];
        dp[arr.length - 1][arr.length - 1] = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j >= 0; j--) {
                int ans1 = 0;
                int ans2 = 0;
                if(i == arr.length-1 && j == arr.length-1){
                    continue;
                }
                if(arr[i][j] != -1 && i < arr.length-1){
                    ans1 = dp[i+1][j];
                }
                if(arr[i][j] != -1 && j < arr.length-1){
                    ans2 = dp[i][j+1];
                }
                dp[i][j] = ans1 + ans2;
            }
        }
        return dp[0][0];
    }
}

// ___________________________________________________________
// Space Optimization

public class Video9_Maze_Obstacles {
    public static void main(String[] args) {
        int[][] arr = {
                { 0, 0, 0, 0, 0 },
                { 0, -1, 0, -1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, -1, 0, 0, 0 },
                { 0, 0, 0, -1, 0 }
        };

        int ans = getAllPaths(arr, 0, 0);
        System.out.println(ans);
    }

    public static int getAllPaths(int[][] arr, int rowStart, int colStart) {
        int[] dp = new int[arr.length];
        int[] temp = new int[arr.length];

        dp[arr.length-1] = 1;

        for(int i=arr.length-1; i>=0; i--){
            for(int j = arr.length-1; j>=0; j--){
                if(arr[i][j] == -1){
                    temp[j] = 0;
                }
                else if(j == arr.length-1 && arr[i][j] != -1){
                    temp[j] = dp[j];
                }else if(j < arr.length-1 && arr[i][j] != -1){
                    temp[j] = dp[j] + temp[j+1];
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}