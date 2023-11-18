
//______________________________________________________________________
// Using Recursion

// import java.util.*;

// public class Video_50_Minimum_Cost_to_Cut_The_Stick {
//     public static void main(String[] args) {
//         ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
//         int c = cuts.size();
//         int n = 7;

//         System.out.println("The minimum cost incurred: " + cost(n, c, cuts));
//     }

//     public static int cost(int n, int c, ArrayList<Integer> cuts) {
//         cuts.add(n);
//         cuts.add(0);
//         Collections.sort(cuts);
//         int[] arr = new int[cuts.size()];
//         for (int i = 0; i < cuts.size(); i++) {
//             arr[i] = cuts.get(i);
//         }

//         return getMinCost(arr, 1, c);
//     }

//     public static int getMinCost(int[] arr, int i, int j) {
//         if (i > j) {
//             return 0;
//         }

//         int mini = Integer.MAX_VALUE;

//         for (int ind = i; ind <= j; ind++) {
//             int ans = arr[j + 1] - arr[i - 1] +
//                     getMinCost(arr, i, ind - 1) +
//                     getMinCost(arr, ind + 1, j);

//             mini = Math.min(mini, ans);
//         }

//         return mini;
//     }
// }

// ______________________________________________________________________
// Using Memoization

// import java.util.*;

// public class Video_50_Minimum_Cost_to_Cut_The_Stick {
//     public static void main(String[] args) {
//         ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
//         int c = cuts.size();
//         int n = 7;

//         System.out.println("The minimum cost incurred: " + cost(n, c, cuts));
//     }

//     public static int cost(int n, int c, ArrayList<Integer> cuts) {
//         cuts.add(n);
//         cuts.add(0);
//         Collections.sort(cuts);
//         int[] arr = new int[cuts.size()];
//         for (int i = 0; i < cuts.size(); i++) {
//             arr[i] = cuts.get(i);
//         }

//         int[][] dp = new int[arr.length][arr.length];
//         for(int[] temp: dp){
//             Arrays.fill(temp,-1);
//         }
//         return getMinCost(arr, 1, c, dp);
//     }

//     public static int getMinCost(int[] arr, int i, int j,int[][] dp) {
//         if (i > j) {
//             return 0;
//         }
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }

//         int mini = Integer.MAX_VALUE;

//         for (int ind = i; ind <= j; ind++) {
//             int ans = arr[j + 1] - arr[i - 1] +
//                     getMinCost(arr, i, ind - 1,dp) +
//                     getMinCost(arr, ind + 1, j,dp);

//             mini = Math.min(mini, ans);
//         }

//         return dp[i][j] = mini;
//     }
// }

// ______________________________________________________________________
// Using Tabulation

import java.util.*;

public class Video_50_Minimum_Cost_to_Cut_The_Stick {
    public static void main(String[] args) {
        ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int c = cuts.size();
        int n = 7;

        System.out.println("The minimum cost incurred: " + cost(n, c, cuts));
    }

    public static int cost(int n, int c, ArrayList<Integer> cuts) {
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);
        int[] arr = new int[cuts.size()];
        for (int i = 0; i < cuts.size(); i++) {
            arr[i] = cuts.get(i);
        }

        return getMinCost(arr, 1, c);
    }

    public static int getMinCost(int[] arr, int n, int c) {
        int[][] dp = new int[arr.length+1][arr.length+1];

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = arr[j + 1] - arr[i - 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }
}