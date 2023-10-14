/*
Problem Statement
You are present at point 'A' which is the top-left cell of an M X N matrix, your destination is point 'B', which is the bottom-right cell of the same matrix. Your task is to find the total number of unique paths from point 'A' to point 'B'.In other words, you will be given the dimensions of the matrix as integers 'M' and 'N', your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1] ['N' - 1]. To traverse in the matrix, you can either move Right or Down at each step. For example in a given point MATRIX[] [il. you can move to either MATRIX[i + 1][l or MATRIX[i][ + 1].

Constraints:
1 < T < 100
1 < M ≤ 15
1 3 N ≤ 15
Where 'M' is the number of rows and 'N'
is the number of columns in the matrix.
Time limit: 1 sec

Sample Input 1:
2
2 2
1 1

Sample Output 1:
2
1

https://www.codingninjas.com/studio/problems/total-unique-paths_1081470?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
*/
//_____________________________________________________________________
// Using Recursion

public class Video_08_Grid_Unique_Paths{
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        System.out.println(printUniquePaths(arr,0,0));
    }
    public static int printUniquePaths(int[][] arr, int rowStart, int colStart){
        if(rowStart == arr.length-1 && colStart == arr[0].length-1){
            return 1;
        }
        int ans1 = 0;
        int ans2 = 0;

        if(rowStart < arr.length-1){
            ans1 = printUniquePaths(arr, rowStart+1, colStart);
        }
        if(colStart < arr[0].length-1){
            ans2 = printUniquePaths(arr, rowStart, colStart+1);
        }
        return ans1 + ans2;
    }
}
//_____________________________________________________________________
// Using Memoization
import java.util.*;

public class Video_08_Grid_Unique_Paths {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int[][] dp = new int[3][3];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int ans = getUniquePaths(arr, 0, 0, dp);
        System.out.println(ans);
    }

    public static int getUniquePaths(int[][] arr, int rowStart, int colStart, int[][] dp) {
        if (rowStart == arr.length - 1 && colStart == arr[0].length - 1) {
            return 1;
        }
        if (dp[rowStart][colStart] != -1) {
            return dp[rowStart][colStart];
        }
        int ans1 = 0;
        int ans2 = 0;

        if (colStart < arr[0].length - 1) {
            ans2 = getUniquePaths(arr, rowStart, colStart + 1, dp);
        }
        if (rowStart < arr.length - 1) {
            ans1 = getUniquePaths(arr, rowStart + 1, colStart, dp);
        }
        return dp[rowStart][colStart] = ans1 + ans2;
    }
}

//_____________________________________________________________________
// Using Tabulation
public class Video_08_Grid_Unique_Paths{
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        System.out.println(printUniquePaths(arr,0,0));
    }
    public static int printUniquePaths(int[][] arr, int rowStart, int colStart){
        int[][] dp = new int[arr.length][arr.length];
        dp[arr.length-1][arr.length-1] = 1;

        int ans1 = 0;
        int ans2 = 0;
        for(int i=arr.length-1; i>=0; i--){
            for(int j=arr.length-1; j>=0; j--){
                ans1 = 0;
                ans2 = 0;
                if(i==arr.length-1 && j==arr.length-1){
                    continue;
                }
                if(i<arr.length-1){
                    ans1 = dp[i+1][j];
                }
                if(j < arr.length-1){
                    ans2 = dp[i][j+1];
                }
                dp[i][j] = ans1 + ans2;
            }
        }
        return dp[0][0];
    }
}

//_____________________________________________________________________
// Space Optimization

public class Video_08_Grid_Unique_Paths {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        System.out.println(printUniquePaths(arr, 0, 0));
    }

    public static int printUniquePaths(int[][] arr, int rowStart, int colStart) {
        int[] dp = new int[arr.length];
        dp[arr.length - 1] = 1;

        int[] temp = new int[dp.length];

        for (int j = 0; j < arr.length; j++) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i == arr.length - 1) {
                    temp[i] = dp[i];
                } else if (i < arr.length - 1) {
                    temp[i] = dp[i] + temp[i+1];
                }
            }
            dp = temp;
        }

        return dp[0];
    }
}
