
//______________________________________________________________________
// Using Recursion
public class Video_19_0_1_knapsack {
    public static void main(String[] args) {
        int[] weight = { 3, 2, 5 };
        int[] value = { 30, 40, 60 };

        int totalWeightOfSack = 6;
        int ans = fillSack(weight, value, 0, totalWeightOfSack);
        System.out.println(ans);
    }

    public static int fillSack(int[] weight, int[] value, int index, int totalWeight) {
        if (index == weight.length) {
            return 0;
        }

        // Not pick
        int ans2 = fillSack(weight, value, index + 1, totalWeight);

        // Pick
        int ans1 = 0;
        if (weight[index] <= totalWeight) {
            ans1 = value[index] + fillSack(weight, value, index + 1, totalWeight - weight[index]);
        }
        return Math.max(ans1, ans2);
    }
}

// _____________________________________________________________________
// Using Memoization
import java.util.*;

public class Video_19_0_1_knapsack {
    public static void main(String[] args) {
        int[] weight = { 3, 2, 5 };
        int[] value = { 30, 40, 60 };
        int totalWeightOfSack = 6;

        int[][] dp = new int[weight.length + 1][totalWeightOfSack + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        int ans = fillSack(weight, value, 0, totalWeightOfSack, dp);
        System.out.println(ans);
    }

    public static int fillSack(int[] weight, int[] value, int index, int totalWeight, int[][] dp) {
        if (index == weight.length) {
            return 0;
        }
        if (dp[index][totalWeight] != -1) {
            return dp[index][totalWeight];
        }

        int ans2 = fillSack(weight, value, index + 1, totalWeight, dp);

        int ans1 = 0;
        if (weight[index] <= totalWeight) {
            ans1 = value[index] + fillSack(weight, value, index + 1,
                    totalWeight - weight[index], dp);
        }
        return dp[index][totalWeight] = Math.max(ans1, ans2);
    }
}

// _____________________________________________________________________
// Using Tabulation

public class Video_19_0_1_knapsack {
    public static void main(String[] args) {
        int[] weight = { 3, 2, 5 };
        int[] value = { 30, 40, 60 };

        int totalWeightOfSack = 6;
        int ans = fillSack(weight, value, 0, totalWeightOfSack);
        System.out.println(ans);
    }

    public static int fillSack(int[] weight, int[] value, int index, int totalWeight) {
        int[][] dp = new int[weight.length + 1][totalWeight + 1];

        for (int i = 0; i <= weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int w = 0; w <= totalWeight; w++) {
            dp[weight.length][w] = 0;
        }

        for (int ind = weight.length - 1; ind >= 0; ind--) {
            for (int totalW = 1; totalW <= totalWeight; totalW++) {
                int ans2 = dp[ind + 1][totalW];
                int ans1 = 0;
                if (weight[ind] <= totalW) {
                    ans1 = value[ind] + dp[ind + 1][totalW - weight[ind]];
                }
                dp[ind][totalW] = Math.max(ans1, ans2);
            }
        }
        return dp[0][totalWeight];
    }
}

// _______________________________________________________________
// Using Space Optimization
public class Video_19_0_1_knapsack {
    public static void main(String[] args) {
        int[] weight = { 3, 2, 5 };
        int[] value = { 30, 40, 60 };

        int totalWeightOfSack = 6;
        int ans = fillSack(weight, value, totalWeightOfSack);
        System.out.println(ans);
    }

    public static int fillSack(int[] weight, int[] value, int totalWeight) {
        int[] front = new int[totalWeight + 1];
        int[] curr = new int[totalWeight + 1];

        front[0] = 0;

        for (int ind = weight.length - 1; ind >= 0; ind--) {
            for (int totalW = 1; totalW <= totalWeight; totalW++) {
                int ans2 = front[totalW];
                int ans1 = 0;
                if (weight[ind] <= totalW) {
                    ans1 = value[ind] + front[totalW - weight[ind]];
                }
                curr[totalW] = Math.max(ans1, ans2);
            }

            int[] temp = front;
            front = curr;
            curr = temp;
        }
        return front[totalWeight];
    }
}

// _________________________________________________________________
// Using single array space optimization

public class Video_19_0_1_knapsack {
    public static void main(String[] args) {
        int[] weight = { 3, 2, 5 };
        int[] value = { 30, 40, 60 };

        int totalWeightOfSack = 6;
        int ans = fillSack(weight, value, totalWeightOfSack);
        System.out.println(ans);
    }

    public static int fillSack(int[] weight, int[] value, int totalWeight) {
        int[] front = new int[totalWeight + 1];

        front[0] = 0;

        for (int ind = weight.length - 1; ind >= 0; ind--) {
            for (int totalW = totalWeight; totalW >= 1; totalW--) {
                int ans2 = front[totalW];
                int ans1 = 0;
                if (weight[ind] <= totalW) {
                    ans1 = value[ind] + front[totalW - weight[ind]];
                }
                front[totalW] = Math.max(ans1, ans2);
            }
        }
        return front[totalWeight];
    }
}