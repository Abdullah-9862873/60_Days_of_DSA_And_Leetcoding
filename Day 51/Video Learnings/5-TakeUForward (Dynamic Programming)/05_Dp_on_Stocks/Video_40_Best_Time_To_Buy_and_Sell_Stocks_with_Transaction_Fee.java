/*
Problem Statement:
You can buy and sell unlimited times... You have to first buy and then sell afterward... Every time a transaction is completed i-e you have sold a stock then whatever profit you'll make transaction fee will be deducted from that profit...

*/
//________________________________________________________________
// Using Recursion

// public class Video_40_Best_Time_To_Buy_and_Sell_Stocks_with_Transaction_Fee {
//     public static void main(String[] args) {
//         int[] arr = {1,3,2,8,4,9};
//         int fee = 2;
//         int ans = getMaxProfit(arr,0,1, fee);
//         System.out.println(ans);
//     }
//     public static int getMaxProfit(int[] arr, int index, int buy, int fee){
//         if(index == arr.length){
//             return 0;
//         }

//         if(buy == 1){
//             int ans1 = -arr[index] + getMaxProfit(arr, index+1, 0, fee);
//             int ans2 = 0 + getMaxProfit(arr, index+1, 1, fee);
//             return Math.max(ans1,ans2);
//         }else{
//             int ans1 = arr[index] - fee + getMaxProfit(arr, index+1, 1, fee);
//             int ans2 = 0 + getMaxProfit(arr, index+1, 0, fee);
//             return Math.max(ans1, ans2);
//         }
//     }
// }

//________________________________________________________________
// Using Memoization

// import java.util.*;
// public class Video_40_Best_Time_To_Buy_and_Sell_Stocks_with_Transaction_Fee {
//     public static void main(String[] args) {
//         int[] arr = {1,3,2,8,4,9};
//         int fee = 2;
//         int[][] dp = new int[arr.length][2];
//         for(int[] temp: dp){
//             Arrays.fill(temp,-1);
//         }
//         int ans = getMaxProfit(arr,0,1, fee,dp);
//         System.out.println(ans);
//     }
//     public static int getMaxProfit(int[] arr, int index, int buy, int fee,int[][] dp){
//         if(index == arr.length){
//             return 0;
//         }
//         if(dp[index][buy] != -1){
//             return dp[index][buy];
//         }

//         if(buy == 1){
//             int ans1 = -arr[index] + getMaxProfit(arr, index+1, 0, fee,dp);
//             int ans2 = 0 + getMaxProfit(arr, index+1, 1, fee,dp);
//             return dp[index][buy] = Math.max(ans1,ans2);
//         }else{
//             int ans1 = arr[index] - fee + getMaxProfit(arr, index+1, 1, fee,dp);
//             int ans2 = 0 + getMaxProfit(arr, index+1, 0, fee,dp);
//             return dp[index][buy] = Math.max(ans1, ans2);
//         }
//     }
// }

//________________________________________________________________
// Using Tabulation

// public class Video_40_Best_Time_To_Buy_and_Sell_Stocks_with_Transaction_Fee {
//     public static void main(String[] args) {
//         int[] arr = { 1, 3, 2, 8, 4, 9 };
//         int fee = 2;
//         int ans = getMaxProfit(arr, fee);
//         System.out.println(ans);
//     }

//     public static int getMaxProfit(int[] arr, int fee) {
//         int[][] dp = new int[arr.length + 1][2];
//         dp[arr.length][0] = 0;
//         dp[arr.length][1] = 0;

//         for (int index = arr.length - 1; index >= 0; index--) {
//             for (int buy = 0; buy <= 1; buy++) {
//                 if (buy == 1) {
//                     int ans1 = -arr[index] + dp[index + 1][0];
//                     int ans2 = 0 + dp[index + 1][1];
//                     dp[index][buy] =  Math.max(ans1, ans2);
//                 } else {
//                     int ans1 = arr[index] - fee + dp[index + 1][1];
//                     int ans2 = 0 + dp[index + 1][0];
//                     dp[index][buy] =  Math.max(ans1, ans2);
//                 }
//             }
//         }
//         return dp[0][1];
//     }
// }

//________________________________________________________________
// Using Space Optimization

public class Video_40_Best_Time_To_Buy_and_Sell_Stocks_with_Transaction_Fee {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        int ans = getMaxProfit(arr, fee);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] arr, int fee) {
        int[] front = new int[arr.length + 1];
        
        front[arr.length] = 0;
        
        for (int index = arr.length - 1; index >= 0; index--) {
            int[] curr = new int[arr.length + 1];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int ans1 = -arr[index] + front[0];
                    int ans2 = 0 + front[1];
                    curr[buy] =  Math.max(ans1, ans2);
                } else {
                    int ans1 = arr[index] - fee + front[1];
                    int ans2 = 0 + front[0];
                    curr[buy] =  Math.max(ans1, ans2);
                }
            }
            front = curr;
        }
        return front[1];
    }
}