/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
*/

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        nums = sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] sort(int[] nums){
        // Find the maximum element and put it at the last index and keep updating the last index
        for(int i=0; i<nums.length; i++){
            int last = nums.length - i - 1;

            int maxElementIndex = findMaxElement(nums, 0, last);
            int temp = nums[maxElementIndex];
            nums[maxElementIndex] = nums[last];
            nums[last] = temp;
        }

        return nums;
    }

    public static int findMaxElement(int[] nums, int start, int end){
        int max = 0;
        for(int i=start; i<=end; i++){
            if(nums[max] < nums[i]){
                max = i;
            }
        }
        return max;
    }
}
