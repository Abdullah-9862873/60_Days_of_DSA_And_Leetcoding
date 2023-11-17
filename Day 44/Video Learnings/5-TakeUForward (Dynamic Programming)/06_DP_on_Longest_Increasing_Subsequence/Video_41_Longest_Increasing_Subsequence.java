/*
Problem Statement:
You have to tell the length of the longest increasing subsequence... That means the length of the longest subsequence that has numbers in increasing order...

For Example:
arr = {10,9,2,5,3,7,101,18}

ans is 4 because {2,3,7,101} is the longest increasing subsequence
*/

//_______________________________________________________________
// Using Recursion

// public class Video_41_Longest_Increasing_Subsequence{
//     public static void main(String[] args) {
//         int[] arr = {10,9,2,5,3,7,101,18};
//         int ans = getLongestIncreasingSubsequence(arr,0, -1);
//         System.out.println(ans);
//     }
//     public static int getLongestIncreasingSubsequence(int[] arr,int index, int lastPickIndex){
//         if(index == arr.length){
//             return 0;
//         }

//         // When can I pick
//         int ans1 = 0;
//         if(lastPickIndex == -1 || (lastPickIndex >= 0 && arr[index] > arr[lastPickIndex])){
//             ans1 = 1 + getLongestIncreasingSubsequence(arr, index+1, index);
//         }

//         int ans2 = 0 + getLongestIncreasingSubsequence(arr, index+1, lastPickIndex);
//         return Math.max(ans1, ans2);
//     }
// }

//_______________________________________________________________
// Using Memoization

// import java.util.*;

// public class Video_41_Longest_Increasing_Subsequence{
//     public static void main(String[] args) {
//         int[] arr = {10,9,2,5,3,7,101,18};
//         int[][] dp = new int[arr.length][arr.length];
//         for (int[] temp : dp) {
//             Arrays.fill(temp, -1);
//         }
//         int ans = getLongestIncreasingSubsequence(arr, 0, -1, dp);
//         System.out.println(ans);
//     }
//     public static int getLongestIncreasingSubsequence(int[] arr,int index, int lastPickIndex,int[][] dp){
//         if(index == arr.length){
//             return 0;
//         }
//         if (lastPickIndex != -1) {
//             if (dp[index][lastPickIndex] != -1) {
//                 return dp[index][lastPickIndex];
//             }
//         }

//         int ans1 = 0;
//         if (lastPickIndex == -1 || (lastPickIndex >= 0 && arr[index] > arr[lastPickIndex])) {
//             ans1 = 1 + getLongestIncreasingSubsequence(arr, index + 1, index, dp);
//         }

//         int ans2 = 0 + getLongestIncreasingSubsequence(arr, index + 1, lastPickIndex, dp);
//         if (lastPickIndex != -1) {
//             return dp[index][lastPickIndex] = Math.max(ans1, ans2);
//         }
//         return Math.max(ans1, ans2);
//     }
// }

//_________________________________________________________
// Following all the stuff is explained in video 42
// Using Tabulation

// public class Video_41_Longest_Increasing_Subsequence {
//     public static void main(String[] args) {
//         int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
//         int ans = getLongestIncreasingSubsequence(arr);
//         System.out.println(ans);
//     }

//     public static int getLongestIncreasingSubsequence(int arr[]){
//         int dp[][]=new int[arr.length+1][arr.length+1];

//         for(int ind = arr.length-1; ind>=0; ind --){
//             for (int lastPickIndex = ind-1; lastPickIndex >=-1; lastPickIndex --){

//                 int ans1 = 0;

//                 if(lastPickIndex == -1 || arr[ind] > arr[lastPickIndex]){

//                     ans1 = 1 + dp[ind+1][ind+1];
//                 }
//                 int ans2 = 0 + dp[ind+1][lastPickIndex +1];

//                 dp[ind][lastPickIndex+1] = Math.max(ans1,ans2);
//             }
//         }

//         return dp[0][0];
//     }
// }

//_________________________________________________________
// Using Space Optimization

// public class Video_41_Longest_Increasing_Subsequence {
//     public static void main(String[] args) {
//         int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
//         int ans = getLongestIncreasingSubsequence(arr);
//         System.out.println(ans);
//     }

//     public static int getLongestIncreasingSubsequence(int arr[]){
//         int[] front = new int[arr.length+1];

//         for(int ind = arr.length-1; ind>=0; ind --){
//             int[] curr = new int[arr.length+1];
//             for (int lastPickIndex = ind-1; lastPickIndex >=-1; lastPickIndex --){

//                 int ans1 = 0;

//                 if(lastPickIndex == -1 || arr[ind] > arr[lastPickIndex]){

//                     ans1 = 1 + front[ind+1];
//                 }
//                 int ans2 = 0 + front[lastPickIndex +1];

//                 curr[lastPickIndex+1] = Math.max(ans1,ans2);
//             }
//             front = curr;
//         }

//         return front[0];
//     }
// }

//_________________________________________________________
// Using Approach 2

public class Video_41_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = getLongestIncreasingSubsequence(arr);
        System.out.println(ans);
    }

    public static int getLongestIncreasingSubsequence(int arr[]){
        int[] dp = new int[arr.length];
        for(int i=0; i<dp.length; i++){
            dp[i] = 1;
        }

        for(int i=0; i<arr.length; i++){
            for(int prev=0; prev<i; prev++){
                if(arr[prev] < arr[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<dp.length; i++){
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}
// Time Complexity --- > n*2
// Space Complexity ---> O(n)