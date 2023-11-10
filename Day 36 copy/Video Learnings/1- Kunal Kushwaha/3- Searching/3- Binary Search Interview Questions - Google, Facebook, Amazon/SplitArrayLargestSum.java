// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

// Return the minimized largest sum of the split.

// A subarray is a contiguous part of the array.

// Example 1:

// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

package neww;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;

        int ans = splitArray(nums, k);
        System.out.println(ans);

    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        // Get the boundaries
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start < end) {

            int mid = start + (end - start) / 2;

            // Calculate how many pieces you can divide the subarray in
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    // I cannot add the new number into the previous subarray so a new subarray
                    // would be made and the sum of that new subarray would be that num at initial
                    // level
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; // here start == end
    }
}
