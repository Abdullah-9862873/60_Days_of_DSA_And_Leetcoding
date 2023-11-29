
//_______________________________________________________
// Using Recursion

// public class Video_51_Burst_Balloons {
//     public static void main(String[] args) {
//         int[] arr = {3,1,5,8};
//         int ans = getMinCost(arr);
//         System.out.println(ans);
//     }
//     public static int getMinCost(int[] arr){
//         int[] newArr = new int[arr.length+2];
//         newArr[0] = 1;
//         newArr[newArr.length-1] = 1;

//         for(int i=0; i<arr.length; i++){
//             newArr[i+1] = arr[i];
//         }

//         return helperFunction(newArr, 1, arr.length);
//     }
//     public static int helperFunction(int[] arr, int i, int j){
//         if(i > j){
//             return 0;
//         }

//         int maxi = Integer.MIN_VALUE;
//         for(int ind=i; ind<=j; ind++){
//             int cost = arr[i-1]*arr[ind]*arr[j+1] + helperFunction(arr, i, ind-1) + helperFunction(arr, ind+1, j);
//             maxi = Math.max(maxi, cost);
//         }
//         return maxi;
//     }
// }

//________________________________________________________________
// Using Memoization

// import java.util.*;

// public class Video_51_Burst_Balloons {
//     public static void main(String[] args) {
//         int[] arr = { 3, 1, 5, 8 };
//         int ans = getMinCost(arr);
//         System.out.println(ans);
//     }

//     public static int getMinCost(int[] arr) {
//         int[] newArr = new int[arr.length + 2];
//         newArr[0] = 1;
//         newArr[newArr.length - 1] = 1;

//         for (int i = 0; i < arr.length; i++) {
//             newArr[i + 1] = arr[i];
//         }

//         int[][] dp = new int[newArr.length + 1][newArr.length + 1];
//         for (int[] temp : dp) {
//             Arrays.fill(temp, -1);
//         }

//         return helperFunction(newArr, 1, arr.length, dp);
//     }

//     public static int helperFunction(int[] arr, int i, int j, int[][] dp) {
//         if (i > j) {
//             return 0;
//         }
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         int maxi = Integer.MIN_VALUE;
//         for (int ind = i; ind <= j; ind++) {
//             int cost = arr[i - 1] * arr[ind] * arr[j + 1] + helperFunction(arr, i, ind - 1, dp)
//                     + helperFunction(arr, ind + 1, j, dp);
//             maxi = Math.max(maxi, cost);
//         }
//         return dp[i][j] = maxi;
//     }
// }

//________________________________________________________________
// Using Tabulation

public class Video_51_Burst_Balloons {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 8 };
        int ans = getMinCost(arr);
        System.out.println(ans);
    }

    public static int getMinCost(int[] arr) {
        int[] newArr = new int[arr.length + 2];
        newArr[0] = 1;
        newArr[newArr.length - 1] = 1;

        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return helperFunction(newArr);
    }

    public static int helperFunction(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];

        for (int i = arr.length - 2; i >= 1; i--) {
            for (int j = 1; j <= arr.length - 2; j++) {
                if (i > j) {
                    continue;
                }
                int maxi = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = arr[i - 1] * arr[ind] * arr[j + 1] + dp[i][ind - 1]
                            + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][arr.length-2];
    }
}