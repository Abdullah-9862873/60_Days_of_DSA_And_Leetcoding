//_____________________________________________________________
// Using Recursion

// public class Video_54_Partition_Array_for_Maximum_Sum {
//     public static void main(String[] args) {
//         int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
//         int k = 3;
//         int ans = getMaxSum(arr, k, 0);
//         System.out.println(ans);
//     }

//     public static int getMaxSum(int[] arr, int k, int i) {
//         if (i == arr.length) {
//             return 0;
//         }

//         int len = 0;
//         int maxi = Integer.MIN_VALUE;
//         int maxAns = Integer.MIN_VALUE;
//         for (int j = i; j < Math.min(i + k, arr.length); j++) {
//             len++;
//             maxi = Math.max(maxi, arr[j]);
//             int sum = len * maxi + getMaxSum(arr, k, j + 1);
//             maxAns = Math.max(maxAns, sum);
//         }
//         return maxAns;
//     }
// }

//______________________________________________________________
// Using Memoization

// import java.util.*;
// public class Video_54_Partition_Array_for_Maximum_Sum {
//     public static void main(String[] args) {
//         int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
//         int k = 3;
//         int[] dp = new int[arr.length];
//         Arrays.fill(dp,-1);
//         int ans = getMaxSum(arr, k, 0,dp);
//         System.out.println(ans);
//     }

//     public static int getMaxSum(int[] arr, int k, int i,int[] dp) {
//         if (i == arr.length) {
//             return 0;
//         }
//         if(dp[i] != -1){
//             return dp[i];
//         }

//         int len = 0;
//         int maxi = Integer.MIN_VALUE;
//         int maxAns = Integer.MIN_VALUE;
//         for (int j = i; j < Math.min(i + k, arr.length); j++) {
//             len++;
//             maxi = Math.max(maxi, arr[j]);
//             int sum = len * maxi + getMaxSum(arr, k, j + 1,dp);
//             maxAns = Math.max(maxAns, sum);
//         }
//         return dp[i] = maxAns;
//     }
// }

//_________________________________________________________
public class Video_54_Partition_Array_for_Maximum_Sum {
    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        int ans = getMaxSum(arr, k);
        System.out.println(ans);
    }

    public static int getMaxSum(int[] arr, int k) {
        int[] dp = new int[arr.length+1];

        for (int i = arr.length - 1; i >= 0; i--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(i + k, arr.length); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
}