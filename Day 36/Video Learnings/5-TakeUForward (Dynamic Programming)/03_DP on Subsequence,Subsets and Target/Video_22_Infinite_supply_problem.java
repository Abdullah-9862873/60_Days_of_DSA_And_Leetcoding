/*
Problem Statement:
You will be given an array like [1,2,3] and a target like "4" and you have to form the target from the given array... But here's the catch, you can use any array element any number of times to form the target

so for example
{1,1,1,1} = 4
{1,1,2} = 4
{2,2} = 4
{1,3} = 4

So the answer to this array is 4
*/

//_______________________________________________________
// Using Recursion

public class Video_22_Infinite_supply_problem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int target = 4;
        int ans = countArrangements(arr, 0, target);
        System.out.println(ans);
    }

    public static int countArrangements(int[] arr, int index, int target) {
        if(target == 0){
            return 1;
        }
        if(index >= arr.length){
            return 0;
        }
        if(index == arr.length-1){
            if(target == arr[index]){
                return 1;
            }
            return 0;
        }

        // Not pick
        int ans1 = countArrangements(arr, index+1, target);

        // Pick
        int ans2 = 0;
        for(int i=1; i<=target/arr[index]; i++){
            if(arr[index] <= target){
                ans2 += countArrangements(arr, index+1, target-(arr[index]*i));
            }
        }
        return ans1 + ans2;
    }
}

// _________________________________________________________
// Using Memoization

import java.util.*;

public class Video_22_Infinite_supply_problem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int target = 4;
        int[][] dp = new int[arr.length][target + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int ans = countArrangements(arr, 0, target, dp);
        System.out.println(ans);
    }

    public static int countArrangements(int[] arr, int index, int target, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (index >= arr.length) {
            return 0;
        }
        if (index == arr.length - 1) {
            if (target == arr[index]) {
                return 1;
            }
            return 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        // Not pick
        int ans1 = countArrangements(arr, index + 1, target, dp);

        // Pick
        int ans2 = 0;
        for (int i = 1; i <= target / arr[index]; i++) {
            if (arr[index] <= target) {
                ans2 += countArrangements(arr, index + 1, target - (arr[index] * i), dp);
            }
        }
        return dp[index][target] = ans1 + ans2;
    }
}

// _________________________________________________________
// Using Tabulation

public class Video_22_Infinite_supply_problem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int target = 4;
        int ans = countArrangements(arr, target);
        System.out.println(ans);
    }

    public static int countArrangements(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];
        // Base Cases
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= target; i++) {
            if (i == arr[arr.length - 1]) {
                dp[arr.length - 1][i] = 1;
            } else {
                dp[arr.length][i] = 0;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                // Not pick
                int ans1 = dp[i + 1][j];

                // Pick
                int ans2 = 0;
                for (int k = 1; k <= j / arr[i]; k++) {
                    if (arr[i] <= j) {
                        ans2 += dp[i + 1][j - (arr[i] * k)];
                    }
                }
                dp[i][j] = ans1 + ans2;
            }
        }

        return dp[0][target];
    }
}
// _________________________________________________________
// Using Space Optimization

public class Video_22_Infinite_supply_problem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int target = 4;
        int ans = countArrangements(arr, target);
        System.out.println(ans);
    }

    public static int countArrangements(int[] arr, int target) {
        int[] front = new int[target + 1];
        int[] curr = new int[target + 1];

        front[0] = 1;
        curr[0] = 1;

        for (int i = 1; i <= target; i++) {
            if (i == arr[arr.length - 1]) {
                curr[i] = 1;
            } else {
                curr[i] = 0;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                // Not pick
                int ans1 = front[j];

                // Pick
                int ans2 = 0;
                for (int k = 1; k <= j / arr[i]; k++) {
                    if (arr[i] <= j) {
                        ans2 += front[j - (arr[i] * k)];
                    }
                }
                curr[j] = ans1 + ans2;
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }

        return front[target];
    }
}