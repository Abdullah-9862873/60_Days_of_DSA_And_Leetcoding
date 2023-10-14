/*
Problem Statement
You are given an array 'arr' containing 'n' non- negative integers. Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum. You just need to find the minimum absolute difference considering any valid division of the array elements.

Example:
Input: 'n' = 5, 'arr' = [3, 1, 5, 2, 8].
Ouput: 1
Explanation: We can partition the given array into {3, 1, 5} and {2, 8}. This will give us the minimum possible absolute difference i.e. (10 - 9 = 1).

Sample Input 1:
4
1 2 3 4

Sample Output 1:
0

*/

public class Video_16_Partition_of_a_set_into_two_subsets {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 6 };
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        int k = totalSum;

        // By using the tabulation technique of question 14
        // When the tabulation is forming dp 2D array then the first row of the dp signifies which target is possible from n-1 to 0...
        // That means it will take totalSum+1 columns and first row that means dp[0] would signify whether that target can be achieved or not... If it can be achieved then it will represent it with 1...

        int[][] dp = new int[arr.length + 1][k + 1];

        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int target = 1; target <= k; target++) {
                boolean ans1 = false;
                if (arr[i] <= target) {
                    ans1 = (dp[i + 1][target - arr[i]] == 1);
                }
                boolean ans2 = dp[i + 1][target] == 1;
                dp[i][target] = (ans1 || ans2) ? 1 : 0;
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0; i<dp[0].length; i++){
            if(dp[0][i] == 1){      // Means it is possible to achieve that target i-e "i" 
            int s1 = i;
            int s2 = totalSum - s1;
            mini = Math.min(mini, Math.abs(s1-s2));
            }
        }
        System.out.println(mini);

    }
}
