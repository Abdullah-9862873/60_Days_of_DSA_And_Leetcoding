/*
Problem Statement:
You are given an array which is basically a rod... Each value of the array is a piece of rod... You have to cut the rod into pieces such that the summation of the pieces you get after cutting the rod are maximum...

For example:
arr = [2,5,7,8,10];
index or values of the pieces are something like
1piece has value arr[0] = 2;
2piece has value arr[1] = 5; and so on

You have cutted into something like 1Piece + 2Pieces + 2Piece...
Then the values are 2 + 5 + 5 = 12

You have to maximise this value...

*/

//___________________________________________________________
// Using Recursion

// public class Video_24_Rod_Cutting_Problem {
//     public static void main(String[] args) {
//         int[] arr = {2,5,7,8,10};
//         int rodLength = arr.length;
//         int ans = cutRodToMaximum(arr, 0,rodLength);
//         System.out.println(ans);
//     }
//     public static int cutRodToMaximum(int[] arr, int index, int rodLength){
//         if(index == arr.length-1){
//             if(rodLength >= 1){
//                 return arr[rodLength-1];
//             }
//             return 0;
//         }
//         if(rodLength == 0){
//             return 0;
//         }

// int ans1 = 0;
// for(int i=1; i<=rodLength/2; i++){
//     ans1 = arr[i-1] + cutRodToMaximum(arr, index+1, rodLength-i);
// }

// int ans2 = 0;
// if(index < arr.length-1){
//     ans2 = arr[rodLength-1] + cutRodToMaximum(arr, index+1, rodLength-rodLength);
// }

//         return Math.max(ans1, ans2);
//     }
// }

//___________________________________________________________
// Using Memoization

// import java.util.*;
// public class Video_24_Rod_Cutting_Problem {
//     public static void main(String[] args) {
//         int[] arr = {2,5,7,8,10};
//         int rodLength = arr.length;
//         int[][] dp = new int[arr.length][rodLength+1];
//         for(int[] temp: dp){
//             Arrays.fill(temp,-1);
//         }
//         int ans = cutRodToMaximum(arr, 0,rodLength, dp);
//         System.out.println(ans);
//     }
//     public static int cutRodToMaximum(int[] arr, int index, int rodLength, int[][] dp){
//         if(index == arr.length-1){
//             if(rodLength >= 1){
//                 return arr[rodLength-1];
//             }
//             return 0;
//         }
//         if(rodLength == 0){
//             return 0;
//         }
//         if(dp[index][rodLength] != -1){
//             return dp[index][rodLength];
//         }

//         int ans1 = 0;
//         for(int i=1; i<=rodLength/2; i++){
//             ans1 = arr[i-1] + cutRodToMaximum(arr, index+1, rodLength-i, dp);
//         }

//         int ans2 = 0;
//         if(index < arr.length-1){
//             ans2 = arr[rodLength-1] + cutRodToMaximum(arr, index+1, rodLength-rodLength, dp);
//         }

//         return dp[index][rodLength] = Math.max(ans1, ans2);
//     }
// }

//___________________________________________________________
// Using Tabulation

// public class Video_24_Rod_Cutting_Problem {
//         public static void main(String[] args) {
//                 int[] arr = { 2, 5, 7, 8, 10 };
//                 int rodLength = arr.length;
//                 int ans = cutRodToMaximum(arr, 0, rodLength);
//                 System.out.println(ans);
//             }
        
//             public static int cutRodToMaximum(int[] arr, int index, int rodLength) {
//                     int[][] dp = new int[arr.length][rodLength + 1];
//                     // Base Case
//                     for (int i = 1; i <= rodLength; i++) {
//                             dp[arr.length - 1][i] = arr[i - 1];
//         }

//         for (int ind = arr.length - 2; ind >= 0; ind--) {
//                 for (int rLength = 1; rLength <= rodLength; rLength++) {
//                 int ans1 = 0;
//                 for (int i = 1; i <= rLength / 2; i++) {
//                         ans1 = arr[i - 1] + dp[ind + 1][rLength - i];
//                     }
    
//                     int ans2 = 0;
//                     if (ind < arr.length - 1) {
//                             ans2 = arr[rLength - 1] + dp[ind + 1][rLength - rLength];
//                 }

//                 dp[ind][rLength] = Math.max(ans1, ans2);
//             }
//         }
//         return dp[0][rodLength];
//     }
// }

//___________________________________________________________
// Using Space optimization

public class Video_24_Rod_Cutting_Problem {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 8, 10 };
        int rodLength = arr.length;
        int ans = cutRodToMaximum(arr, 0, rodLength);
        System.out.println(ans);
    }

    public static int cutRodToMaximum(int[] arr, int index, int rodLength) {
        int[] front = new int[rodLength + 1];
        int[] curr = new int[rodLength + 1];

        // Base Case
        for(int i=1; i<=rodLength; i++){
            front[i] = arr[i-1];
        }

        for (int ind = arr.length - 2; ind >= 0; ind--) {
            for (int rLength = 1; rLength <= rodLength; rLength++) {
                int ans1 = 0;
                for (int i = 1; i <= rLength / 2; i++) {
                    ans1 = arr[i - 1] + front[rLength - i];
                }

                int ans2 = 0;
                if (ind < arr.length - 1) {
                    ans2 = arr[rLength - 1] + front[rLength - rLength];
                }

                curr[rLength] = Math.max(ans1, ans2);
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        return curr[rodLength];
    }
}