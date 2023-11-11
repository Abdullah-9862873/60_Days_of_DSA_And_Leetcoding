/*
Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Note :-  l and r denotes the starting and ending index of the array.

Example 1:

Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
Output : 7
Explanation :
3rd smallest element in the given 
array is 7.
*/

import java.util.Arrays;

public class Problem_3_Kth_max_and_min_element{
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};  // [3,4,7,10,15,20]
        int k = 3;

        Arrays.sort(arr);
        int min = arr[k-1];
        int max = arr[arr.length - k];
        System.out.println("Kth max is: " + max);
        System.out.println("Kth min is: " + min);
    }
}