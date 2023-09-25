import java.util.Arrays;

// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

// Return the running sum of nums.

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]
// Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };

        int[] ans = new int[nums.length];

        int i = 0;
        int sum = 0;
        while (i < nums.length) {
            sum += nums[i];
            ans[i] = sum;
            i++;
        }

        System.out.println(Arrays.toString(ans));
    }
}
