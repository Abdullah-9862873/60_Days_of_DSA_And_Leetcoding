/*
Question ----> A robber can rob the money from the houses but it cannot rob from two adjacent houses and the first house and the last one are adjacent to each other... If he robs two adjacent houses then police will get to know...s
*/
//_____________________________________________________________________________
// Using Recursion
public class Video6_House_Robber {
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
public class Video6_House_Robber {
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
public class Video6_House_Robber {
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
public class Video6_House_Robber {
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