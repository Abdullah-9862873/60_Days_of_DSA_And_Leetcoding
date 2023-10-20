//___________________________________________________
// Printing Longest Increasing Subsequence

import java.util.Arrays;

public class Video_42_Printing_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int[] ans = getLongestIncreasingSubsequence(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] getLongestIncreasingSubsequence(int arr[]) {
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        int maxi = Integer.MIN_VALUE;
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && (1 + dp[prev] > dp[i])) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                    if (dp[i] > maxi) {
                        maxi = dp[i];
                        lastIndex = i;
                    }
                    hash[i] = prev;
                }
            }
        }


        int[] ans = new int[maxi];
        for (int i = 0; i < ans.length; i++) {
            int val = arr[lastIndex];
            ans[i] = val;
            lastIndex = hash[lastIndex];
        }

        int start = 0;
        int end = ans.length-1;
        while(start < end){
            int temp = ans[start];
            ans[start] = ans[end];
            ans[end] = temp;
            start++;
            end--;
        }
        return ans;
    }
}