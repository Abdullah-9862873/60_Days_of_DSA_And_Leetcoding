
/*
Problem Statement:
You have to buy on the minimum price and sell on the maximum... You cannot do something like buy on day 4 but sell on day 1... It has to be in order... You can buy at most two times and sell two times...
*/
//________________________________________________________________
// Using Recursion

public class Video_37_Best_Time_To_Buy_And_Sell_Stocks_3 {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int ans = getMaxProfit(arr, 0, 1, 2);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] arr, int index, int buy, int buyCount) {
        if (index == arr.length) {
            return 0;
        }
        if (buyCount == 0) {
            return 0;
        }

        if (buy == 1) {
            int ans1 = 0 + getMaxProfit(arr, index + 1, 1, buyCount); // Not bought
            int ans2 = -arr[index] + getMaxProfit(arr, index + 1, 0, buyCount); // bought
            return Math.max(ans1, ans2);
        } else {
            int ans1 = 0 + getMaxProfit(arr, index + 1, 0, buyCount); // Not sold
            int ans2 = arr[index] + getMaxProfit(arr, index + 1, 1, buyCount - 1); // sold
            return Math.max(ans1, ans2);
        }
    }
}

//________________________________________________________________
// Using Memoization

import java.util.*;
public class Video_37_Best_Time_To_Buy_And_Sell_Stocks_3 {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int[][][] dp = new int[arr.length][2][3];
        for(int[][] temp: dp){
            for(int[] temp2: temp){
                Arrays.fill(temp2,-1);
            }
        }
        int ans = getMaxProfit(arr, 0, 1, 2,dp);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] arr, int index, int buy, int buyCount, int[][][] dp) {
        if (index == arr.length) {
            return 0;
        }
        if (buyCount == 0) {
            return 0;
        }
        if(dp[index][buy][buyCount] != -1){
            return dp[index][buy][buyCount];
        }

        if (buy == 1) {
            int ans1 = 0 + getMaxProfit(arr, index + 1, 1, buyCount,dp); // Not bought
            int ans2 = -arr[index] + getMaxProfit(arr, index + 1, 0, buyCount,dp); // bought
            return dp[index][buy][buyCount] = Math.max(ans1, ans2);
        } else {
            int ans1 = 0 + getMaxProfit(arr, index + 1, 0, buyCount,dp); // Not sold
            int ans2 = arr[index] + getMaxProfit(arr, index + 1, 1, buyCount - 1,dp); // sold
            return dp[index][buy][buyCount] = Math.max(ans1, ans2);
        }
    }
}

//________________________________________________________________
// Using Tabulation

public class Video_37_Best_Time_To_Buy_And_Sell_Stocks_3 {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int ans = getMaxProfit(arr);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] arr) {
        int[][][] dp = new int[arr.length + 1][2 + 1][3 + 1];

        // Base Cases

        for (int buy = 0; buy <= 1; buy++) {
            for (int buyCount = 0; buyCount < dp[0][0].length; buyCount++) {
                dp[arr.length][buy][buyCount] = 0;
            }
        }
        for (int index = 0; index < dp.length; index++) {
            for (int buy = 0; buy <= 1; buy++) { 
                dp[index][buy][0] = 0;
            }
        }

        for (int index = arr.length-1; index >= 0; index--) {
            for (int buy = 0; buy <= 1 ; buy++) {
                for (int buyCount = 1; buyCount<=2; buyCount++) { 
                    if (buy == 1) {
                        int ans1 = 0 + dp[index + 1][1][buyCount]; // Not bought
                        int ans2 = -arr[index] + dp[index + 1][0][buyCount]; // bought
                        dp[index][buy][buyCount] = Math.max(ans1, ans2);
                    } else {
                        int ans1 = 0 + dp[index + 1][0][buyCount]; // Not sold
                        int ans2 = arr[index] + dp[index + 1][1][buyCount - 1]; // sold
                        dp[index][buy][buyCount] = Math.max(ans1, ans2);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}

//________________________________________________________________
// Using Space Optimization

public class Video_37_Best_Time_To_Buy_And_Sell_Stocks_3 {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int ans = getMaxProfit(arr);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] arr) {
        int[][] front = new int[2 + 1][3 + 1];
        int[][] curr = new int[2 + 1][3 + 1];

        // Base Cases

        for (int buy = 0; buy <= 1; buy++) {
            for (int buyCount = 0; buyCount < front[0].length; buyCount++) {
                front[buy][buyCount] = 0;
            }
        }
        for (int index = 0; index < front.length; index++) {
            for (int buy = 0; buy <= 1; buy++) {
                front[buy][0] = 0;
            }
        }

        for (int index = arr.length - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int buyCount = 1; buyCount <= 2; buyCount++) {
                    if (buy == 1) {
                        int ans1 = 0 + front[1][buyCount]; // Not bought
                        int ans2 = -arr[index] + front[0][buyCount]; // bought
                        curr[buy][buyCount] = Math.max(ans1, ans2);
                    } else {
                        int ans1 = 0 + front[0][buyCount]; // Not sold
                        int ans2 = arr[index] + front[1][buyCount - 1]; // sold
                        curr[buy][buyCount] = Math.max(ans1, ans2);
                    }
                }
            }
            front = curr;
        }
        return front[1][2];
    }
}
