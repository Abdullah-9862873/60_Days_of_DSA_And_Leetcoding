/*
Problem Statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k' Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'K'. Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.

Sample Input 1:
4 5
1 4 4 5

Sample Output 1 :

Explanation For Sample Output 1:
The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note
that both 1 present in 'arr' are treated
differently

*/
//_____________________________________________________________
// Using Recursion

// public class Video_17_Count_Subsets_with_sum_k {
//     public static void main(String[] args) {
//         int[] arr = {1,2,2,3};
//         int k = 3;

//         int ans = countSubsetsWithSumK(arr,0,k);
//         System.out.println(ans);
//     }
//     public static int countSubsetsWithSumK(int[] arr,int index, int k){
//         if(k == 0){
//             return 1;
//         }
//         if(index == arr.length-1){
//             if(arr[index] == k){
//                 return 1;
//             }else{
//                 return 0;
//             }
//         }

// int ans1 = countSubsetsWithSumK(arr, index+1, k);
// int ans2 = 0;
// if(arr[index] <= k){
//     ans2 = countSubsetsWithSumK(arr, index+1, k-arr[index]);
// }
// return ans1 + ans2;
//     }
// }

//__________________________________________________________
// Using Memoization
// import java.util.*;
// public class Video_17_Count_Subsets_with_sum_k {
//     public static void main(String[] args) {
//         int[] arr = {1,2,2,3};
//         int k = 3;
//         int[][] dp = new int[arr.length][k+1];
//         for(int[] temp: dp){
//             Arrays.fill(temp,-1);
//         }

//         int ans = countSubsetsWithSumK(arr,0,k,dp);
//         System.out.println(ans);
//     }
//     public static int countSubsetsWithSumK(int[] arr,int index, int k, int[][] dp){
//         if(k == 0){
//             return 1;
//         }
//         if(index == arr.length-1){
//             if(arr[index] == k){
//                 return 1;
//             }else{
//                 return 0;
//             }
//         }
//         if(dp[index][k] != -1){
//             return dp[index][k];
//         }

//         int ans1 = countSubsetsWithSumK(arr, index+1, k,dp);
//         int ans2 = 0;
//         if(arr[index] <= k){
//             ans2 = countSubsetsWithSumK(arr, index+1, k-arr[index],dp);
//         }
//         return dp[index][k] = ans1 + ans2;
//     }
// }

//________________________________________________________
// Using Tabulation

// public class Video_17_Count_Subsets_with_sum_k {
//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 2, 3 };
//         int k = 3;

//         int ans = countSubsetsWithSumK(arr, 0, k);
//         System.out.println(ans);
//     }

    // public static int countSubsetsWithSumK(int[] arr, int index, int k) {
    //     int[][] dp = new int[arr.length+1][k + 1];
    //     for (int i = 0; i <= arr.length; i++) {
    //         dp[i][0] = 1;
    //     }
    //     if(arr[index] <= k){
    //         dp[arr.length - 1][arr[index]] = 1;
    //     }

    //     for (int i = arr.length - 1; i >= 0; i--) {
    //         for (int target = 1; target <= k; target++) {
    //             int ans1 = dp[i+1][target];
    //             int ans2 = 0;
    //             if (arr[i] <= target) {
    //                 ans2 = dp[i+1][target-arr[i]];
    //             }
    //             dp[i][target] = ans1 + ans2;
    //         }
    //     }
    //     return dp[0][k];
    // }
// }

//________________________________________________________
// Using Space Optimization

public class Video_17_Count_Subsets_with_sum_k {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int k = 3;

        int ans = countSubsetsWithSumK(arr, 0, k);
        System.out.println(ans);
    }

    public static int countSubsetsWithSumK(int[] arr, int index, int k) {
        int[] front = new int[k + 1];
        int[] curr = new int[k+1];
        front[0] = 1;
        curr[0] = 1;

        if(arr[index] <= k){
            front[arr[index]] = 1;
        }

        for (int i = arr.length - 1; i >= 1; i--) {
            for (int target = 1; target <= k; target++) {
                int ans1 = front[target];
                int ans2 = 0;
                if (arr[i] <= target) {
                    ans2 = front[target-arr[i]];
                }
                curr[target] = ans1 + ans2;
            }
            front = curr;
        }
        return curr[k];
    }
}