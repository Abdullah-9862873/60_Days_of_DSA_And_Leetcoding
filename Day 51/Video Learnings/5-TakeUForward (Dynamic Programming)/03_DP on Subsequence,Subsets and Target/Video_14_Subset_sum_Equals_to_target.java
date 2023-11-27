//________________________________________________________
// Using Recursion

// public class Video_14_Subset_sum_Equals_to_target{
//     public static void main(String[] args) {
//         int[] arr = {1,2,3,4};
//         int k = 4;

//         boolean ans = isSubsetSumEqualsK(arr,0, k);
//         System.out.println(ans);
//     }
//     public static boolean isSubsetSumEqualsK(int[] arr,int index, int k){
// if(k == 0){
//     return true;
// }
// if(index == arr.length-1){
//     return arr[index] == k;
// }
//         boolean ans1 = false;
//         if(arr[index] >= k){
//             ans1 = isSubsetSumEqualsK(arr, index+1, k-arr[index]);
//         }
//         boolean ans2 = isSubsetSumEqualsK(arr, index+1, k);
//         return ans1 || ans2;
//     }
//     public static void printPairs(int[] arr,int index, int k, String asf,int sum){
//         if(index >= arr.length){
//             if(index==arr.length){
//                 if(sum == k){
//                     System.out.println(asf);
//                 }
//             }
//             return;
//         }

//         printPairs(arr, index+1, k, asf, sum);
//         printPairs(arr, index+1, k, asf.isEmpty() ? String.valueOf(arr[index]) : asf + "-" + String.valueOf(arr[index]), sum+arr[index]);
//     }
// }

//_________________________________________________________
// Using Memoization

// import java.util.*;

// public class Video_14_Subset_sum_Equals_to_target {
//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 3, 4 };
//         int k = 4;
//         int[][] dp = new int[arr.length][k + 1];
//         for (int[] temp : dp) {
//             Arrays.fill(temp, -1);
//         }

//         boolean ans = isSubsetSumEqualsK(arr, 0, k, dp);
//         System.out.println(ans);
//     }

//     public static boolean isSubsetSumEqualsK(int[] arr, int index, int k, int[][] dp) {
//         if (k == 0) {
//             return true;
//         }
//         if (index == arr.length - 1) {
//             return arr[index] == k;
//         }
//         if (dp[index][k] != -1) {
//             return dp[index][k] == 1;
//         }
//         boolean ans1 = false;
//         if (arr[index] <= k) {
//             ans1 = isSubsetSumEqualsK(arr, index + 1, k - arr[index], dp);
//         }
//         boolean ans2 = isSubsetSumEqualsK(arr, index + 1, k, dp);
//         dp[index][k] = (ans1 || ans2) ? 1 : 0;
//         return dp[index][k] == 1;
//     }
// }

// ________________________________________________________
// Using Tabulation

// public class Video_14_Subset_sum_Equals_to_target {
// public static void main(String[] args) {
// int[] arr = { 1, 2, 3, 4 };
// int k = 4;

// boolean ans = isSubsetSumEqualsK(arr, 0, k);
// System.out.println(ans);
// }

// public static boolean isSubsetSumEqualsK(int[] arr, int index, int k) {
// int[][] dp = new int[arr.length + 1][k + 1];

// for (int i = 0; i <= arr.length; i++) {
// dp[i][0] = 1;
// }

// for (int i = arr.length - 1; i >= 0; i--) {
// for (int target = 1; target <= k; target++) {
// boolean ans1 = false;
// if (arr[i] <= target) {
// ans1 = (dp[i + 1][target - arr[i]] == 1);
// }
// boolean ans2 = dp[i + 1][target] == 1;
// dp[i][target] = (ans1 || ans2) ? 1 : 0;
// }
// }
// return dp[0][k] == 1;
// }
// }

// _______________________________________________________________
// Using Space Optimization

public class Video_14_Subset_sum_Equals_to_target {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 4;

        boolean ans = isSubsetSumEqualsK(arr, 0, k);
        System.out.println(ans);
    }

    public static boolean isSubsetSumEqualsK(int[] arr, int index, int k) {
        int[] front = new int[k + 1];
        int[] curr = new int[k + 1];

        if (arr[0] <= k) {
            front[0] = 1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int target = 1; target <= k; target++) {
                boolean ans1 = false;
                if (arr[i] <= target) {
                    ans1 = (front[target - arr[i]] == 1);
                }
                boolean ans2 = front[target] == 1;
                curr[target] = (ans1 || ans2) ? 1 : 0;
            }
            front = curr;
        }
        return curr[k] == 1;
    }
}

/*
 * Notes---> To optimize the space using tabulation
 * 1---> Make the dp one dimension less
 * 2---> if there is dp[i+1][] in your tabulation then make the dp name to front
 * as in this case
 * 3---> Make another array of the same dimension as front and same size
 * 4---> Keep replacing all the dp[i+1] with "front" and then when the loop ends
 * 5---> front = curr
 * 6---> At last you'll get your answer in the curr
 */