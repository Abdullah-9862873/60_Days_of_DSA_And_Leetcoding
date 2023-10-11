// Using Recursion
public class Video4_Frog_Jump_with_K_distance {
    public static void main(String[] args) {
        int[] arr = {30,10,60,10,60,50};
        int k = 3;
        int initialStep = 0;
        int finalStep = arr.length-1;
        int ans = getAns(arr, k, initialStep, finalStep);
        System.out.println(ans);
    }
    public static int getAns(int[] arr, int k, int initialStep, int finalStep){
        if(initialStep >= finalStep){
            return 0;
        }

        int mini = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(initialStep + i <= finalStep){
                int cost = Math.abs(arr[initialStep] - arr[initialStep+i]);
                mini = Math.min(mini, getAns(arr, k, initialStep+i, finalStep) + cost);
            }
        }

        return mini;
    }
// }

//________________________________________________________________________
// Using Memoization

import java.util.Arrays;

public class Video4_Frog_Jump_with_K_distance {
    public static void main(String[] args) {
        int[] arr = { 30, 10, 60, 10, 60, 50 };
        int k = 3;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int initialStep = 0;
        int finalStep = arr.length - 1;
        int ans = getAns(arr, k, initialStep, finalStep, dp);
        System.out.println(ans);
    }

    public static int getAns(int[] arr, int k, int initialStep, int finalStep, int[] dp) {
        if (initialStep >= finalStep) {
            return 0;
        }

        if(dp[initialStep] != -1){
            return dp[initialStep];
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (initialStep + i <= finalStep) {
                int cost = Math.abs(arr[initialStep] - arr[initialStep + i]);
                mini = Math.min(mini, getAns(arr, k, initialStep + i, finalStep, dp) + cost);
            }
        }

        return dp[initialStep] = mini;
    }
}

//___________________________________________________________________
// Using Tabulation
import java.util.*;

public class Video4_Frog_Jump_with_K_distance {
    public static void main(String[] args) {
        int[] arr = { 30, 10, 60, 10, 60, 50 };
        int k = 3;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int initialStep = 0;
        int finalStep = arr.length - 1;
        int ans = getAns(arr, k, initialStep, finalStep, dp);
        System.out.println(ans);
    }

    public static int getAns(int[] arr, int k, int initialStep, int finalStep, int[] dp) {
        if (initialStep >= finalStep) {
            return 0;
        }

        dp[initialStep] = 0;

        for (int i = initialStep + 1; i <= finalStep; i++) {
            for (int j = Math.max(i - k, initialStep); j < i; j++) {
                int cost = Math.abs(arr[i] - arr[j]);
                dp[i] = Math.min(dp[i], dp[j] + cost);
            }
        }

        return dp[finalStep];
    }
}
