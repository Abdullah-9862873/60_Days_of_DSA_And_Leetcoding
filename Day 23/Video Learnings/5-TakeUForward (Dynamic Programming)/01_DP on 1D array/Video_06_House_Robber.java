/*
Problem Statement
Mr. X is a professional robber planning to rob houses along a street. Each house has a certain amount of money hidden. All houses along this street are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night. You are given an array/list of non-negative integers 'ARR' representing the amount of money of each house. Your task is to return the maximum amount of money Mr. X can rob tonight without alerting the police.

Constraints:
1 <= T <= 10
1 <= ARR[i] <= 10 ^ 9
Time limit: 1 sec.
s
Sample Input 1:
1
3
2 3 2
4
1 3 2 1

Sample Output 1:
0
3
4

https://www.codingninjas.com/studio/problems/house-robber_839733?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

*/
//_____________________________________________________________________________
// Using Recursion
public class Video_06_House_Robber {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        int ans = robHouses(arr, 0, arr.length-1);
        System.out.println(ans);
    }
    public static int robHouses(int[] arr, int start, int end){
        if(arr.length == 1){
            return arr[0];
        }
        // Starting house included and ending exluded
        int ans1 = getMaxSumFromNonAdjacentElements(arr, start, end-1);
        // Starting house excluded and ending included
        int ans2 = getMaxSumFromNonAdjacentElements(arr, start+1, end);
        return Math.max(ans1, ans2);
    }
    public static int getMaxSumFromNonAdjacentElements(int[] arr, int start, int end){
        if(end == start){
            return arr[start];
        }
        if(end < start){
            return 0;
        }
        // pick
        int ans1 = arr[end] + getMaxSumFromNonAdjacentElements(arr, start, end-2);
        // no pick
        int ans2 = 0 + getMaxSumFromNonAdjacentElements(arr, start, end-1);

        return Math.max(ans1, ans2);
    }
}

// _______________________________________________________________________
// Using Memoization
import java.util.*;
public class Video_06_House_Robber {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        int ans = robHouses(arr, 0, arr.length-1);
        System.out.println(ans);
    }
    public static int robHouses(int[] arr, int start, int end){
        if(arr.length == 1){
            return arr[0];
        }
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        // Starting house included and ending excluded
        int ans1 = getMaxSumFromNonAdjacentElements(arr, start, end-1, dp);
        // Starting house excluded and ending included
        int ans2 = getMaxSumFromNonAdjacentElements(arr, start+1, end, dp);
        return Math.max(ans1, ans2);
    }
    public static int getMaxSumFromNonAdjacentElements(int[] arr, int start, int end, int[] dp){
        if(end == start){
            return arr[start];
        }
        if(end < start){
            return 0;
        }
        if(end < 2 && end >= 0 && dp[end] != -1){
            return dp[end];
        }
        // pick
        int ans1 = arr[end] + getMaxSumFromNonAdjacentElements(arr, start, end-2, dp);
        // no pick
        int ans2 = 0 + getMaxSumFromNonAdjacentElements(arr, start, end-1, dp);

        return dp[end]= Math.max(ans1, ans2);
    }
}

// _______________________________________________________________________
// Using Tabulation
public class Video_06_House_Robber {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        int ans = robHouses(arr, 0, arr.length-1);
        System.out.println(ans);
    }
    public static int robHouses(int[] arr, int start, int end){
        if(arr.length == 1){
            return arr[0];
        }
        // Starting house included and ending excluded
        int ans1 = getMaxSumFromNonAdjacentElements(arr, start, end-1);
        // Starting house excluded and ending included
        int ans2 = getMaxSumFromNonAdjacentElements(arr, start+1, end);
        return Math.max(ans1, ans2);
    }
    public static int getMaxSumFromNonAdjacentElements(int[] arr, int start, int end){
        if(end == start){
            return arr[start];
        }
        if(end < start){
            return 0;
        }

        int[] dp = new int[arr.length];

        for(int i=start; i<=end; i++){
            // pick
            int pick = arr[i];
            if(i - 2 >= start){
                pick += dp[i-2];
            }
            // Not pick
            int notPick = 0;
            if(i-1 >= start){
                notPick += dp[i-1];
            }
            dp[i] = Math.max(pick, notPick);
        }

        return dp[end];
    }
}

// _______________________________________________________________________
// Using Space Optimization
public class Video_06_House_Robber {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        int ans = robHouses(arr, 0, arr.length-1);
        System.out.println(ans);
    }
    public static int robHouses(int[] arr, int start, int end){
        if(arr.length == 1){
            return arr[0];
        }
        // Starting house included and ending excluded
        int ans1 = getMaxSumFromNonAdjacentElements(arr, start, end-1);
        // Starting house excluded and ending included
        int ans2 = getMaxSumFromNonAdjacentElements(arr, start+1, end);
        return Math.max(ans1, ans2);
    }
    public static int getMaxSumFromNonAdjacentElements(int[] arr, int start, int end){
        if(end == start){
            return arr[start];
        }
        if(end < start){
            return 0;
        }

        int prev = arr[start];
        int prev2 = 0;

        for(int i=start; i<=end; i++){
            // pick
            int pick = arr[i];
            if(i - 2 >= start){
                pick += prev2;
            }
            // Not pick
            int notPick = 0;
            if(i-1 >= start){
                notPick += prev;
            }
            int current = Math.max(pick, notPick);
            prev2 = prev;
            prev = current;
        }

        return prev;
    }
}
