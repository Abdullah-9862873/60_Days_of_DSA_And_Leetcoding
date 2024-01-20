/*
Problem statement:
arr = {1,4,16,7,8}

You are given an array and you have to tell me the longest divisible subset length... Subsets are something that can be in any order... Like {7,1} can be the subset of the given array... 

Example:
Longest divisible subset is : {1,4,8,16}
Length is 4

 */


import java.util.*;
public class Video_44_Longest_Divisible_Subset {
    public static void main(String[] args) {
        int[] arr = {1,4,16,7,8};
        int[] ans = getLongestIncreasingSubset(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] getLongestIncreasingSubset(int[] arr) {
        Arrays.sort(arr);
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
                if (arr[i] % arr[prev]==0 && (1 + dp[prev] > dp[i])) {
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
