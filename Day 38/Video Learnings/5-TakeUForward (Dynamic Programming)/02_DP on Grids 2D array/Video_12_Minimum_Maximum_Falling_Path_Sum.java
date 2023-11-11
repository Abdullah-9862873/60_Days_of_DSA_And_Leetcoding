/*
Problem Statement
You have been given an N*M matrix filled with integer numbers, find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row. From a cell in a row, you can move to another cell directly below that row, or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.

Down: (row+1, col)
Down left diagonal: (row+1,co1-1)
Down right diagonal: (row+1, co1+1)

Constraints :
1 <= T <= 50
1 <= N <= 100
1 <= M <= 100
-10^4 <= matrix[i][jl <= 10^4
Where 'T' is the number of test cases.
Where 'N' is the number of rows in the
given matrix, and 'M' is the number of
columns in the given matrix.
And, matrix[i][j] denotes the value at
(i,j) cell in the matrix.
Time Limit: 1sec

Input 1 :
2
4 4
1 2 10 4
100 3 2 1
1 1 20 2
1 2 2 1
3 3
10 2 3
3 7 2
8 1 5

Output 1 :
105
25

https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
*/
//__________________________________________________________________
// Variable Starting and Ending points
// Solutions for Maximum Falling Path Sum

//__________________________________________________________________
// Using Recursion

public class Video_12_Minimum_Maximum_Falling_Path_Sum{
    public static void main(String[] args){
        int[][] arr = {
            {1,2,10,4},
            {100,3,2,1},
            {1,1,20,2},
            {1,2,2,1},
        };
        int ans = printAllPaths(arr);
        System.out.println(ans);
    }
    public static int printAllPaths(int[][] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr[0].length; i++){
            int ans = helperFunction(arr, 0, i);
            if(ans > max){
                max = ans;
            }
        }
        return max;
    }
    public static int helperFunction(int[][] arr, int rowStart, int colStart){
        if(rowStart == arr.length-1){
            return arr[rowStart][colStart];
        }

        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;
        int ans3 = Integer.MIN_VALUE;
        // Left Diagonal
        if(colStart > 0 && rowStart < arr.length-1){
            ans1 = arr[rowStart][colStart] + helperFunction(arr, rowStart+1, colStart-1);
        }
        // Bottom
        if(rowStart<arr.length-1){
            ans2 = arr[rowStart][colStart] + helperFunction(arr, rowStart+1, colStart);
        }
        // Right Diagonal
        if(colStart < arr[0].length-1 && rowStart < arr.length-1){
            ans3 = arr[rowStart][colStart] + helperFunction(arr, rowStart+1, colStart+1);
        }
        return Math.max(Math.max(ans1, ans2), ans3);
    }
}

//__________________________________________________________________
// Using Memoization

import java.util.*;

public class Video_12_Minimum_Maximum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 },
        };
        int ans = printAllPaths(arr);
        System.out.println(ans);
    }

    public static int printAllPaths(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr[0].length; i++) {
            int[][] dp = new int[arr.length][arr[0].length];
            for (int[] temp : dp) {
                Arrays.fill(temp, -1);
            }
            int ans = helperFunction(arr, 0, i, dp);
            if (ans > max) {
                max = ans;
            }
        }
        return max;
    }

    public static int helperFunction(int[][] arr, int rowStart, int colStart, int[][] dp) {
        if (rowStart == arr.length - 1) {
            return dp[rowStart][colStart] = arr[rowStart][colStart];
        }
        if (dp[rowStart][colStart] != -1) {
            return dp[rowStart][colStart];
        }

        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;
        int ans3 = Integer.MIN_VALUE;
        // Left Diagonal
        if (colStart > 0 && rowStart < arr.length - 1) {
            ans1 = arr[rowStart][colStart] + helperFunction(arr, rowStart + 1, colStart - 1, dp);
        }
        // Bottom
        if (rowStart < arr.length - 1) {
            ans2 = arr[rowStart][colStart] + helperFunction(arr, rowStart + 1, colStart, dp);
        }
        // Right Diagonal
        if (colStart < arr[0].length - 1 && rowStart < arr.length - 1) {
            ans3 = arr[rowStart][colStart] + helperFunction(arr, rowStart + 1, colStart + 1, dp);
        }
        return dp[rowStart][colStart] = Math.max(Math.max(ans1, ans2), ans3);
    }
}

//__________________________________________________________________
// Using Tabulation

public class Video_12_Minimum_Maximum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 },
        };
        int ans = printAllPaths(arr);
        System.out.println(ans);
    }

    public static int printAllPaths(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            int ans = helperFunction(arr, 0, i);
            if (ans > max) {
                max = ans;
            }
        }
        return max;
    }

    public static int helperFunction(int[][] arr, int rowStart, int colStart) {

        int[][] dp = new int[arr.length][arr[0].length];
        int lastRow = arr.length - 1;
        int lastRowSize = arr[lastRow].length;
        for (int i = 0; i < lastRowSize; i++) {
            dp[lastRow][i] = arr[lastRow][i];
        }

        int totalRowsRemaining = arr.length - 2;
        for (int i = totalRowsRemaining; i >= 0; i--) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                if (i == rowStart && j < colStart) {
                    break;
                }
                int ans1 = Integer.MIN_VALUE;
                int ans2 = Integer.MIN_VALUE;
                int ans3 = Integer.MIN_VALUE;
                // Checking if the position where you are at is below the colStart or at the
                // right of the colStart diagonal and we can visit that position or at the left
                // of the colStart diagonal and we can visit that position
                if ((j >= colStart && (j - i <= colStart)) || (j < colStart && (j + i >= colStart))) {
                    // Checking if I can move at Left Diagonal
                    if (j > 0 && i < arr.length - 1) {
                        ans1 = arr[i][j] + dp[i + 1][j - 1];
                    }
                    // Checking if I can move downward
                    if (i < arr.length - 1) {
                        ans2 = arr[i][j] + dp[i + 1][j];
                    }
                    // Checking if I can move at Right Diagonal
                    if (j < arr[i].length - 1 && i < arr.length - 1) {
                        ans3 = arr[i][j] + dp[i + 1][j + 1];
                    }
                    dp[i][j] = Math.max(ans3, Math.max(ans1, ans2));
                }
                // If I have encountered a place at the left diagonal side of the colStart that I cannot visit then all the spaces at the left of that position cannot be visited
                else if((j >= colStart && (j - i <= colStart)) && !(j < colStart && (j + i >= colStart))){
                    break;
                }
            }
        }
        return dp[rowStart][colStart];
    }
}

//____________________________________________________________________________________________________
// Using Space Optimization

public class Video_12_Minimum_Maximum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 },
        };
        int ans = printAllPaths(arr);
        System.out.println(ans);
    }

    public static int printAllPaths(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            int ans = helperFunction(arr, 0, i);
            if (ans > max) {
                max = ans;
            }
        }
        return max;
    }

    public static int helperFunction(int[][] arr, int rowStart, int colStart) {

        int[] dp = new int[arr[0].length];
        
        int lastRow = arr.length - 1;
        int lastRowSize = arr[lastRow].length;
        for (int i = 0; i < lastRowSize; i++) {
            dp[i] = arr[lastRow][i];
        }
        int totalRowsRemaining = arr.length - 2;
        for (int i = totalRowsRemaining; i >= 0; i--) {
            int[] temp = new int[dp.length];
            for (int j = arr[i].length - 1; j >= 0; j--) {
                int ans1 = Integer.MIN_VALUE;
                int ans2 = Integer.MIN_VALUE;
                int ans3 = Integer.MIN_VALUE;
                if ((j >= colStart && (j - i <= colStart)) || (j < colStart && (j + i >= colStart))) {
                    // Left Diagonal
                    if (j > 0 && i < arr.length - 1) {
                        ans1 = arr[i][j] + dp[j - 1];
                    }
                    // Below
                    if (i < arr.length - 1) {
                        ans2 = arr[i][j] + dp[j];
                    }
                    // Right Diagonal
                    if (j < arr[i].length - 1 && i < arr.length - 1) {
                        ans3 = arr[i][j] + dp[j + 1];
                    }
                    temp[j] = Math.max(Math.max(ans1, ans2), ans3);
                }
            }
            dp = temp;
        }
        return dp[colStart];
    }
}
