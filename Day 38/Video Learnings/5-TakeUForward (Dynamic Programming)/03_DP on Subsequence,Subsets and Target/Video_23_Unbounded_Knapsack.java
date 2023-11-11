/*
 * Problem Statement:
 * This is exactly the 0/1 knapsack but the difference is that here you have the
 * inifinit supply of each item so by the end of the robbery the robber should
 * have the items with the maximum value sum...
 * 
 * For example:
 * For the following test case
 * int[] weight = {2,4,6};
 * int[] value = {5,11,13};
 * 
 * int totalWeightOfTheSack = 10;
 * The robber can get something like it will pick the item at the 0th index
 * twice and the item at the last index once
 * So the total value will be
 * 2*5 + 1*13 = 23
 */

// _________________________________________________________________________
// Using Recursion

public class Video_23_Unbounded_Knapsack {
    public static void main(String[] args) {
        int[] weight = { 2, 4, 6 };
        int[] value = { 5, 11, 13 };

        int totalWeightOfTheSack = 10;
        int ans = calculateMaxValueSum(weight, value, 0, totalWeightOfTheSack);
        System.out.println(ans);
    }

    public static int calculateMaxValueSum(int[] weight, int[] value, int index,
            int totalWeight) {
        if (totalWeight == 0) {
            return 0;
        }
        if (index == weight.length - 1) {
            if (totalWeight % weight[index] == 0) {
                return totalWeight / weight[index] * value[index];
            }
            return 0;
        }

        // Not picking
        int ans1 = calculateMaxValueSum(weight, value, index + 1, totalWeight);

        // Pick
        int maxi = Integer.MIN_VALUE;
        int ans2 = 0;
        for (int i = 1; i <= totalWeight / weight[index]; i++) {
            ans2 = (value[index] * i) + calculateMaxValueSum(weight, value, index + 1,
                    totalWeight - weight[index] * i);
            maxi = Math.max(maxi, ans2);
        }
        return Math.max(maxi, ans1);
    }
}

// _________________________________________________________________________
// Using Memoization

import java.util.*;

public class Video_23_Unbounded_Knapsack {
    public static void main(String[] args) {
        int[] weight = { 2, 4, 6 };
        int[] value = { 5, 11, 13 };

        int totalWeightOfTheSack = 10;
        int[][] dp = new int[weight.length][totalWeightOfTheSack + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int ans = calculateMaxValueSum(weight, value, 0, totalWeightOfTheSack, dp);
        System.out.println(ans);
    }

    public static int calculateMaxValueSum(int[] weight, int[] value, int index,
            int totalWeight, int[][] dp) {
        if (totalWeight == 0) {
            return 0;
        }
        if (index == weight.length - 1) {
            if (totalWeight % weight[index] == 0) {
                return totalWeight / weight[index] * value[index];
            }
            return 0;
        }
        if (dp[index][totalWeight] != -1) {
            return dp[index][totalWeight];
        }

        // Not picking
        int ans1 = calculateMaxValueSum(weight, value, index + 1, totalWeight, dp);

        // Pick
        int maxi = Integer.MIN_VALUE;
        int ans2 = 0;
        for (int i = 1; i <= totalWeight / weight[index]; i++) {
            ans2 = (value[index] * i) + calculateMaxValueSum(weight, value, index + 1,
                    totalWeight - weight[index] * i, dp);
            maxi = Math.max(maxi, ans2);
        }
        return dp[index][totalWeight] = Math.max(maxi, ans1);
    }
}

// _________________________________________________________________________
// Using Tabulation

public class Video_23_Unbounded_Knapsack {
    public static void main(String[] args) {
        int[] weight = { 2, 4, 6 };
        int[] value = { 5, 11, 13 };

        int totalWeightOfTheSack = 10;
        int ans = calculateMaxValueSum(weight, value, 0, totalWeightOfTheSack);
        System.out.println(ans);
    }

    public static int calculateMaxValueSum(int[] weight, int[] value, int index,
            int totalWeight) {
        int[][] dp = new int[weight.length + 1][totalWeight + 1];

        for (int i = 0; i <= weight.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= totalWeight; i++) {
            if (i % weight[weight.length - 1] == 0) {
                dp[weight.length - 1][i] = i / weight[weight.length - 1] *
                        value[weight.length - 1];
            } else {
                dp[weight.length - 1][i] = 0;
            }
        }

        for (int i = weight.length - 1; i >= 0; i--) {
            for (int j = 1; j <= totalWeight; j++) {
                // Not picking
                int ans1 = dp[i + 1][j];

                // Pick
                int maxi = Integer.MIN_VALUE;
                int ans2 = 0;
                for (int k = 1; k <= j / weight[i]; k++) {
                    ans2 = (value[i] * k) + dp[i + 1][j - weight[i] * k];
                    maxi = Math.max(maxi, ans2);
                }
                dp[i][j] = Math.max(maxi, ans1);
            }
        }
        return dp[0][totalWeight];
    }
}

// _________________________________________________________________________
// Using Space optimization
public class Video_23_Unbounded_Knapsack {
    public static void main(String[] args) {
        int[] weight = { 2, 4, 6 };
        int[] value = { 5, 11, 13 };

        int totalWeightOfTheSack = 10;
        int ans = calculateMaxValueSum(weight, value, 0, totalWeightOfTheSack);
        System.out.println(ans);
    }

    public static int calculateMaxValueSum(int[] weight, int[] value, int index,
            int totalWeight) {
        int[] front = new int[totalWeight + 1];
        int[] curr = new int[totalWeight + 1];

        front[0] = 0;
        curr[0] = 0;

        for (int i = 0; i <= totalWeight; i++) {
            if (i % weight[weight.length - 1] == 0) {
                front[i] = i / weight[weight.length - 1] *
                        value[weight.length - 1];
            } else {
                front[i] = 0;
            }
        }

        for (int i = weight.length - 1; i >= 0; i--) {
            for (int j = 1; j <= totalWeight; j++) {
                // Not picking
                int ans1 = front[j];

                // Pick
                int maxi = Integer.MIN_VALUE;
                int ans2 = 0;
                for (int k = 1; k <= j / weight[i]; k++) {
                    ans2 = (value[i] * k) + front[j - weight[i] * k];
                    maxi = Math.max(maxi, ans2);
                }
                curr[j] = Math.max(maxi, ans1);
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        return front[totalWeight];
    }
}