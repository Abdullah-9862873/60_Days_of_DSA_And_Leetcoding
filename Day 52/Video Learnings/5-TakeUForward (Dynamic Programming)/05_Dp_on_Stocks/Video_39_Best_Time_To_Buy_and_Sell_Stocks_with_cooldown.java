/*
Problem Statement:
The problem states that you can buy and sell unlimited times and the profit will be the summation of all the transactions but you cannot buy right after selling... This is what cooldown means that you cannot buy right after selling...
*/

//___________________________________________________________________
// Using Recursion

// public class Video_39_Best_Time_To_Buy_and_Sell_Stocks_with_cooldown {
//     public static void main(String[] args) {
//         int[] arr = { 4, 9, 0, 4, 10 };
//         int ans = getMaxProfit(arr, 0, 1);
//         System.out.println(ans);
//     }

//     public static int getMaxProfit(int[] arr, int index, int buy) {
//         if (index >= arr.length) {
//             return 0;
//         }
//         if (buy == 1) {
//             int ans1 = -arr[index] + getMaxProfit(arr, index + 1, 0);
//             int ans2 = 0 + getMaxProfit(arr, index + 1, 1);
//             return Math.max(ans1, ans2);
//         }
//         int ans1 = arr[index] + getMaxProfit(arr, index + 2, 1); // I have sold so I cant move to the right next so index + 2
//         int ans2 = 0 + getMaxProfit(arr, index + 1, 0);
//         return Math.max(ans1, ans2);
//     }
// }

//___________________________________________________________________
// Using Memoization

// import java.util.*;

// public class Video_39_Best_Time_To_Buy_and_Sell_Stocks_with_cooldown {
//     public static void main(String[] args) {
//         int[] arr = { 4, 9, 0, 4, 10 };
//         int[][] dp = new int[arr.length][2];
//         for(int[] temp: dp){
//             Arrays.fill(temp,-1);
//         }
//         int ans = getMaxProfit(arr, 0, 1,dp);
//         System.out.println(ans);
//     }

//     public static int getMaxProfit(int[] arr, int index, int buy, int[][] dp) {
//         if (index >= arr.length) {
//             return 0;
//         }
//         if(dp[index][buy] != -1){
//             return dp[index][buy];
//         }
//         if (buy == 1) {
//             int ans1 = -arr[index] + getMaxProfit(arr, index + 1, 0,dp);
//             int ans2 = 0 + getMaxProfit(arr, index + 1, 1,dp);
//             return Math.max(ans1, ans2);
//         }
//         int ans1 = arr[index] + getMaxProfit(arr, index + 2, 1,dp);
//         int ans2 = 0 + getMaxProfit(arr, index + 1, 0,dp);
//         return Math.max(ans1, ans2);
//     }
// }

//___________________________________________________________________
// Using Tabulation

// public class Video_39_Best_Time_To_Buy_and_Sell_Stocks_with_cooldown {
//     public static void main(String[] args) {
//         int[] arr = { 4, 9, 0, 4, 10 };
//         int ans = getMaxProfit(arr);
//         System.out.println(ans);
//     }

//     public static int getMaxProfit(int[] arr) {
//         int[][] dp = new int[arr.length + 2][2];

//         dp[arr.length - 1][0] = 0;
//         dp[arr.length - 1][1] = 0;

//         for (int index = arr.length - 1; index >= 0; index--) {
//             for (int buy = 0; buy <= 1; buy++) {
//                 if (buy == 1) {
//                     int ans1 = -arr[index] + dp[index + 1][0];
//                     int ans2 = 0 + dp[index + 1][1];
//                     dp[index][buy] = Math.max(ans1, ans2);
//                 } else {
//                         int ans1 = arr[index] + dp[index + 2][1];
//                         int ans2 = 0 + dp[index + 1][0];
//                         dp[index][buy] = Math.max(ans1, ans2);
//                 }
//             }
//         }
//         return dp[0][1];
//     }
// }

//___________________________________________________________________
/*
Note---->
Space Optimization for this tabulation is not a good thing to do because there is index+2 involve in this solution so we have to keep track of three arrays... Which is not a very good approach
*/

// Optimization

public class Video_39_Best_Time_To_Buy_and_Sell_Stocks_with_cooldown {
    public static void main(String[] args) {
        int[] arr = { 4, 9, 0, 4, 10 };
        int ans = getMaxProfit(arr);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] arr) {
        int[] front = new int[2];
        int[] front2 = new int[2];
        int[] curr = new int[2];

        for (int index = arr.length - 1; index >= 0; index--) {
            curr[1] = Math.max(-arr[index] + front[0], 0 + front[1]);
            curr[0] = Math.max(arr[index] + front2[1], 0 + front[0]);
            front2 = front.clone();
            front = curr.clone();
        }
        return curr[1];
    }
}