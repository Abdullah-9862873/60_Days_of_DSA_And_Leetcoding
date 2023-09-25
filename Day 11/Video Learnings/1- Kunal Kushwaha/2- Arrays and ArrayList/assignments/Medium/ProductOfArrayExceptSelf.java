/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

*/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int[] forwardMultipliers = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            forwardMultipliers[i] = arr[i];
        }
        
        for(int i=0; i<forwardMultipliers.length; i++){
            if(i == 0){
                forwardMultipliers[i] = 0;
            }
            else if(i == 1){
                forwardMultipliers[i] = arr[0];
            }else{
                forwardMultipliers[i] = forwardMultipliers[i-1] * arr[i-1];
            }
        }

        // Setting up backward multipliers
        int[] backMultipliers = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            backMultipliers[i] = arr[i];
        }

        for(int i=backMultipliers.length-1; i>=0; i--){
            if(i == backMultipliers.length-1){
                backMultipliers[i] = 0;
            }else if(i == backMultipliers.length -2){
                backMultipliers[i] = arr[backMultipliers.length-1];
            }else{
                backMultipliers[i] = backMultipliers[i+1] * arr[i+1];
            }
        }

        // Now I have gotten forward and backward multipliers
        int[] ans = new int[arr.length];
        ans[0] = backMultipliers[0];
        ans[arr.length-1] = forwardMultipliers[arr.length-1];

        for(int i=1; i<forwardMultipliers.length-1; i++){
            ans[i] = forwardMultipliers[i] * backMultipliers[i];
        }

        System.out.println(Arrays.toString(ans));

    }
}
