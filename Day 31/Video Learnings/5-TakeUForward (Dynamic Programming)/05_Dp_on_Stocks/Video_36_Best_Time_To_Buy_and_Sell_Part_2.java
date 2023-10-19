
/*
Problem Statement:
You have to buy on the minimum price and sell on the maximum... You cannot do something like buy on day 4 but sell on day 1... It has to be in order... You can buy as many times as you want and you can sell as many times as you want...
*/
//_______________________________________________________________
// Using Recursion

public class Video_36_Best_Time_To_Buy_and_Sell_Part_2 {
    public static void main(String[] args) {
        int[] days = { 7, 1, 5, 3, 6, 4 };
        int buy = 1; // 1 indicates I can buy and 0 indicates I can't
        int ans = getMaxProfit(days, 0, buy);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] days, int index, int buy) {
        if (index == days.length) {
            return 0;
        }

        int profit = 0;
        if (buy == 1) {
            int profits1 = -days[index] + getMaxProfit(days, index + 1, 0);
            int profits2 = 0 + getMaxProfit(days, index + 1, 1);
            profit = Math.max(profits1, profits2);
        } else {
            int profits1 = days[index] + getMaxProfit(days, index + 1, 1);
            int profits2 = 0 + getMaxProfit(days, index + 1, 0);
            profit = Math.max(profits1, profits2);
        }
        return profit;
    }
}

// __________________________________________________________
// Using Memoization

import java.util.*;

public class Video_36_Best_Time_To_Buy_and_Sell_Part_2 {
    public static void main(String[] args) {
        int[] days = { 7, 1, 5, 3, 6, 4 };
        int buy = 1;
        int[][] dp = new int[days.length][2];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int ans = getMaxProfit(days, 0, buy, dp);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] days, int index, int buy, int[][] dp) {
        if (index == days.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit = 0;
        if (buy == 1) {
            int profits1 = -days[index] + getMaxProfit(days, index + 1, 0, dp);
            int profits2 = 0 + getMaxProfit(days, index + 1, 1, dp);
            profit = Math.max(profits1, profits2);
        } else {
            int profits1 = days[index] + getMaxProfit(days, index + 1, 1, dp);
            int profits2 = 0 + getMaxProfit(days, index + 1, 0, dp);
            profit = Math.max(profits1, profits2);
        }
        return profit;
    }
}

// ________________________________________________________________________
// Using Tabulation

public class Video_36_Best_Time_To_Buy_and_Sell_Part_2 {
    public static void main(String[] args) {
        int[] days = { 7, 1, 5, 3, 6, 4 };
        int ans = getMaxProfit(days);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] days) {
        int[][] dp = new int[days.length + 1][2];

        dp[days.length - 1][0] = 0;
        dp[days.length - 1][1] = 0;

        for (int index = days.length - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    int profits1 = -days[index] + dp[index + 1][0];
                    int profits2 = 0 + dp[index + 1][1];
                    profit = Math.max(profits1, profits2);
                } else {
                    int profits1 = days[index] + dp[index + 1][1];
                    int profits2 = 0 + dp[index + 1][0];
                    profit = Math.max(profits1, profits2);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }
}

// ________________________________________________________
// Using Space Optimization

public class Video_36_Best_Time_To_Buy_and_Sell_Part_2 {
    public static void main(String[] args) {
        int[] days = { 7, 1, 5, 3, 6, 4 };
        int ans = getMaxProfit(days);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] days) {
        int[] front = new int[days.length + 1];

        front[0] = 0;
        front[1] = 0;

        for (int index = days.length - 1; index >= 0; index--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    int profits1 = -days[index] + front[0];
                    int profits2 = 0 + front[1];
                    profit = Math.max(profits1, profits2);
                } else {
                    int profits1 = days[index] + front[1];
                    int profits2 = 0 + front[0];
                    profit = Math.max(profits1, profits2);
                }
                curr[buy] = profit;
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        return front[1];
    }
}