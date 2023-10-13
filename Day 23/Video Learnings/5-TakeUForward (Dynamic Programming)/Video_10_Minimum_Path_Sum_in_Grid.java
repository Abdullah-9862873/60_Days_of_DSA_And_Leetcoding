
/*
Problem Statement
Ninjaland is a country in the shape of a 2- Dimensional grid 'GRID', with 'N' rows and 'M' columns. Each point in the grid has some cost associated with it. Find a path from top left i.e. (0, 0) to the bottom right i.e. ('N' - 1, 'M' - 1) which minimizes the sum of the cost of all the numbers along the path. You need to tell the minimum sum of that path.

Constraints:
1 <= T <= 100
1 <= N, M <= 10^2
1 < GRID[i][j] <= 10^5
Where 'GRID[i]lj]' denotes the value of
the cell in the matrix.
Time limit: 1 sec

Sample Input 1:
2
2 3
5 9 6
11 5 2
1 1
5

Sample Output 1:
21
5

https://www.codingninjas.com/studio/problems/minimum-path-sum_985349?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
*/
//_____________________________________________________________
// Using Recursion
public class Video10_Minimum_Path_Sum_in_Grid {
    public static void main(String[] args) {
        int[][] arr = {
            {5,9,6},
            {11,5,2}
        };
        int ans = getCostOfAllPaths(arr, 0,0);
        System.out.println(ans);
    }
    public static int getCostOfAllPaths(int[][] arr, int rowStart, int colStart){
        if(rowStart == arr.length-1 && colStart == arr[0].length-1){
            return arr[rowStart][colStart];
        }

        int firstAnswer = Integer.MAX_VALUE;
        int secondAnswer = Integer.MAX_VALUE;
        if(rowStart < arr.length-1){
            firstAnswer = arr[rowStart][colStart] +getCostOfAllPaths(arr, rowStart+1, colStart);
        }
        if(colStart < arr[0].length-1){
            secondAnswer = arr[rowStart][colStart] + getCostOfAllPaths(arr, rowStart, colStart+1);
        }
        return Math.min(firstAnswer, secondAnswer);
    }
}

// _____________________________________________________________
// Memoization
import java.util.*;

public class Video10_Minimum_Path_Sum_in_Grid {
    public static void main(String[] args) {
        int[][] arr = {
                { 5, 9, 6 },
                { 11, 5, 2 }
        };
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int ans = getCostOfAllPaths(arr, 0, 0, dp);
        System.out.println(ans);
    }

    public static int getCostOfAllPaths(int[][] arr, int rowStart, int colStart, int[][] dp) {
        if (rowStart == arr.length - 1 && colStart == arr[0].length - 1) {
            return dp[rowStart][colStart] = arr[rowStart][colStart];
        }
        if (dp[rowStart][colStart] != -1) {
            return dp[rowStart][colStart];
        }

        int firstAnswer = Integer.MAX_VALUE;
        int secondAnswer = Integer.MAX_VALUE;
        if (rowStart < arr.length - 1) {
            firstAnswer = arr[rowStart][colStart] + getCostOfAllPaths(arr, rowStart + 1, colStart, dp);
        }
        if (colStart < arr[0].length - 1) {
            secondAnswer = arr[rowStart][colStart] + getCostOfAllPaths(arr, rowStart, colStart + 1, dp);
        }
        return dp[rowStart][colStart] = Math.min(firstAnswer, secondAnswer);
    }
}

// _____________________________________________________________
// Using Tabulation
public class Video10_Minimum_Path_Sum_in_Grid {
    public static void main(String[] args) {
        int[][] arr = {
                { 5, 9, 6 },
                { 11, 5, 2 }
        };
        int ans = getCostOfAllPaths(arr, 0, 0);
        System.out.println(ans);
    }

    public static int getCostOfAllPaths(int[][] arr, int rowStart, int colStart) {
        int[][] dp = new int[arr.length][arr[0].length];
        dp[arr.length - 1][arr[0].length - 1] = arr[arr.length - 1][arr[0].length - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (i == arr.length - 1 && j == arr[0].length - 1) {
                    continue;
                } else if (i == arr.length - 1 && j < arr[0].length - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (i < arr.length - 1 && j == arr.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                } else if (i < arr.length - 1 && j < arr.length - 1) {
                    int ans1 = arr[i][j] + dp[i + 1][j];
                    int ans2 = arr[i][j] + dp[i][j + 1];
                    dp[i][j] = Math.min(ans1, ans2);
                }
            }
        }
        return dp[0][0];
    }
}

// _____________________________________________________________
// Space Optimization
public class Video10_Minimum_Path_Sum_in_Grid {
    public static void main(String[] args) {
        int[][] arr = {
                { 5, 9, 6 },
                { 11, 5, 2 }
        };
        int ans = getCostOfAllPaths(arr, 0, 0);
        System.out.println(ans);
    }

    public static int getCostOfAllPaths(int[][] arr, int rowStart, int colStart) {
        int[] dp = new int[arr[0].length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int[] temp = new int[arr[0].length];
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (i == arr.length - 1 && j == arr[0].length - 1) {
                    temp[j] = arr[i][j];
                } else if (i == arr.length - 1 && j < arr[0].length - 1) {
                    temp[j] = arr[i][j] + temp[j + 1];
                } else if (i < arr.length - 1 && j == arr[0].length - 1) {
                    temp[j] = arr[i][j] + dp[j];
                } else if (i < arr.length - 1 && j < arr[0].length - 1) {
                    int ans1 = arr[i][j] + temp[j + 1];
                    int ans2 = arr[i][j] + dp[j];
                    temp[j] = Math.min(ans1, ans2);
                }
            }
            dp = temp;
        }

        return dp[0];
    }
}