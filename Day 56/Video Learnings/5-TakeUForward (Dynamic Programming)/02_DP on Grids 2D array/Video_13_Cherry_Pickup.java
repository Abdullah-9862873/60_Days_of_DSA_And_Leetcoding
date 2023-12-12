/*
Problem Statement
Ninja has a 'GRID' of size 'R' X'C'. Each cell of the grid contains some chocolates. Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible with the help of his friends. Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, 'C' - 1) in the grid. Each of them can move from their current cell to the cells just below them. When anyone passes from any cell, he will pick all chocolates in it, and then the number of chocolates in that cell will become zero. If both stay in the same cell, only one of them will pick the chocolates in it. If Alice or Bob is at (i, j) then they can move to (i + 1, j). (i + 1, j - 1) or (i + 1, j + 1). They will always stay inside the 'GRID'. Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following the above rules.
Example:

Constraints :
1 <= 'T' <= 10
2 <= 'R', 'C' <= 50
• <= 'GRID[i][j]'‹= 10^2
Time Limit: 1sec

Sample Input 1:
2
3 4
2 3 1 2
3 4 2 2
5 6 3 5
2 2
1 1
12

Sample Output 1:
22
5


*/
// _____________________________________________________________________________
// Using Recursion
public class Video_13_Cherry_Pickup {
    public static void main(String[] args) {
        int[][] arr = {
            { 2, 1, 2 },
            { 2, 3, 2 },
            { 1, 5, 5 },
        };

        int rowStart = 0;
        int aliceColStart = 0;
        int bobColStart = arr[0].length - 1;
        int totalRows = arr.length;
        int totalCols = arr[0].length;
        printAllPaths(arr, rowStart, aliceColStart, bobColStart, totalRows, totalCols, "", "");
        int maximumPathSum = getMaximumPathSum(arr, rowStart, aliceColStart, bobColStart, totalRows, totalCols);
        System.out.println("Maximum Sum Path is: "+ maximumPathSum);
    }

    public static int getMaximumPathSum(int[][] arr, int i, int j1, int j2, int r, int c){
        if(j1<0 || j1>=c || j2<0 || j2>=c){
            return (int)-1e8;
        }
        if(i == r-1){
            if(j1 == j2){
                return arr[i][j1];
            }else{
                return arr[i][j1] + arr[i][j2];
            }
        }

        // Exploring all paths
        int maxi = (int)-1e8;
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                int value = 0;
                if(j1 == j2){
                    value = arr[i][j1];
                }else{
                    value = arr[i][j1] + arr[i][j2];
                }
                value += getMaximumPathSum(arr, i+1, j1+dj1, j2+dj2, r, c);
                maxi = Math.max(maxi, value);
            }
        }
        return maxi;
    }

    public static void printAllPaths(int[][] arr, int i, int j1, int j2, int r, int c, String alicePath, String bobPath) {
      if (i >= r || j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) {
          return;
      }
      if (i == r - 1) {
          // I am standing at the last row
          System.out.println("Alice Path: " + alicePath + arr[i][j1]);
          System.out.println("Bob Path: " + bobPath + arr[i][j2]);
          System.out.println("_____________________________");
          return;
      }

      for (int dj1 = -1; dj1 <= 1; dj1++) {
          for (int dj2 = -1; dj2 <= 1; dj2++) {
              // Ensure that Alice and Bob don't overlap
              if (j1 + dj1 != j2 + dj2) {
                  String newAlicePath = alicePath + arr[i][j1] + "-";
                  String newBobPath = bobPath + arr[i][j2] + "-";
                  printAllPaths(arr, i + 1, j1 + dj1, j2 + dj2, r, c, newAlicePath, newBobPath);
              }
          }
      }
  }
}

// _____________________________________________________________________________
// Using Memoization
// import java.util.*;
// public class Video_13_Cherry_Pickup {
//     public static void main(String[] args) {
//         int[][] arr = {
//             { 2, 1, 2 },
//             { 2, 3, 2 },
//             { 1, 5, 5 },
//         };

//         int rowStart = 0;
//         int aliceColStart = 0;
//         int bobColStart = arr[0].length - 1;
//         int totalRows = arr.length;
//         int totalCols = arr[0].length;
//         // Here dp is made three dimensional because there are three variables that are changing in every reucursion call... 
//         // Variables are (i)(j1)(j2)... Maximum values that i can get are (totalRows)... Maximum values that j1 and j2 can get are (totalCols)
//         int[][][] dp = new int[totalRows][totalCols][totalCols];
//         for(int[][] temp : dp){
//             for(int[] temp2 : temp){
//                 Arrays.fill(temp2, -1);
//             }
//         }
//         int maximumPathSum = getMaximumPathSum(arr, rowStart, aliceColStart, bobColStart, totalRows, totalCols,dp);
//         System.out.println("Maximum Sum Path is: "+ maximumPathSum);
//     }

//     public static int getMaximumPathSum(int[][] arr, int i, int j1, int j2, int r, int c, int[][][] dp){
//         if(j1<0 || j1>=c || j2<0 || j2>=c){
//             return (int)-1e8;
//         }
//         if(i == r-1){
//             if(j1 == j2){
//                 return arr[i][j1];
//             }else{
//                 return arr[i][j1] + arr[i][j2];
//             }
//         }
//         if(dp[i][j1][j2] != -1){
//             return dp[i][j1][j2];
//         }

//         // Exploring all paths
//         int maxi = (int)-1e8;
//         for(int dj1=-1; dj1<=1; dj1++){
//             for(int dj2=-1; dj2<=1; dj2++){
//                 int value = 0;
//                 if(j1 == j2){
//                     value = arr[i][j1];
//                 }else{
//                     value = arr[i][j1] + arr[i][j2];
//                 }
//                 value += getMaximumPathSum(arr, i+1, j1+dj1, j2+dj2, r, c,dp);
//                 maxi = Math.max(maxi, value);
//             }
//         }
//         return dp[i][j1][j2] = maxi;
//     }
// }

// _____________________________________________________________________________
// Using Tabulation
// public class Video_13_Cherry_Pickup {
//     public static void main(String[] args) {
//         int[][] arr = {
//                 { 2, 1, 2 },
//                 { 2, 3, 2 },
//                 { 1, 5, 5 },
//         };

//         int totalRows = arr.length;
//         int totalCols = arr[0].length;
//         int maximumPathSum = getMaximumPathSum(arr, totalRows, totalCols);
//         System.out.println("Maximum Sum Path is: " + maximumPathSum);
//     }

//     public static int getMaximumPathSum(int[][] arr, int n, int m) {
//         int[][][] dp = new int[n][m][m];
//         // Base Cases
        // for (int j1 = 0; j1 < m; j1++) {
        //     for (int j2 = 0; j2 < m; j2++) {
        //       if (j1 == j2)
        //         dp[n - 1][j1][j2] = arr[n - 1][j1];
        //       else
        //         dp[n - 1][j1][j2] = arr[n - 1][j1] + arr[n - 1][j2];
        //     }
        //   }

//         // Converting the recursion calls to for loops
//         for (int i = n - 2; i >= 0; i--) {
//             for (int j1 = 0; j1 < m; j1++) {
//               for (int j2 = 0; j2 < m; j2++) {
//                 int maxi = Integer.MIN_VALUE;

//                 // Inner nested loops to try out 9 options
//                 for (int di = -1; di <= 1; di++) {
//                   for (int dj = -1; dj <= 1; dj++) {
//                     int ans;

//                     if (j1 == j2)
//                       ans = arr[i][j1];
//                     else
//                       ans = arr[i][j1] + arr[i][j2];

//                     // Check if the indices are valid
//                     if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
//                       ans += (int) Math.pow(-10, 9);
//                     else
//                       ans += dp[i + 1][j1 + di][j2 + dj];

//                     // Update maxi with the maximum result
//                     maxi = Math.max(ans, maxi);
//                   }
//                 }
//                 // Store the result in the dp array
//                 dp[i][j1][j2] = maxi;
//               }
//             }
//           }

//         return dp[0][0][m-1];
//     }
// }

// _____________________________________________________________________________
// Using Space Optimization 
// public class Video_13_Cherry_Pickup {
//   public static void main(String[] args) {
//     int[][] arr = {
//         { 2, 1, 2 },
//         { 2, 3, 2 },
//         { 1, 5, 5 },
//     };

//     int totalRows = arr.length;
//     int totalCols = arr[0].length;
//     int maximumPathSum = getMaximumPathSum(arr, totalRows, totalCols);
//     System.out.println("Maximum Sum Path is: " + maximumPathSum);
//   }

//   public static int getMaximumPathSum(int[][] grid, int n, int m) {
//     int[][] front = new int[m][m];
//     int[][] cur = new int[m][m];
//     // Base Cases
//     for (int j1 = 0; j1 < m; j1++) {
//       for (int j2 = 0; j2 < m; j2++) {
//         if (j1 == j2)
//           front[j1][j2] = grid[n - 1][j1];
//         else
//           front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
//       }
//     }

//     for (int i = n - 2; i >= 0; i--) {
//       for (int j1 = 0; j1 < m; j1++) {
//         for (int j2 = 0; j2 < m; j2++) {
//           int maxi = Integer.MIN_VALUE;

//           // Inner nested loops to try out 9 options
//           for (int di = -1; di <= 1; di++) {
//             for (int dj = -1; dj <= 1; dj++) {
//               int ans;

//               if (j1 == j2)
//                 ans = grid[i][j1];
//               else
//                 ans = grid[i][j1] + grid[i][j2];

//               // Check if the indices are valid
//               if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
//                 ans += (int) Math.pow(-10, 9);
//               else
//                 ans += front[j1 + di][j2 + dj];

//               // Update maxi with the maximum result
//               maxi = Math.max(ans, maxi);
//             }
//           }
//           // Store the result in the cur array
//           cur[j1][j2] = maxi;
//         }
//       }

//       // Update the front array with the values from the cur array for the next row
//       for (int a = 0; a < m; a++) {
//         front[a] = cur[a].clone();
//       }
//     }

//     // The final result is stored at the top left corner of the front array
//     return front[0][m - 1];
//   }
// }