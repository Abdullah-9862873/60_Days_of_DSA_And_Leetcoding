/*
Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.

Examples:

Input: arr[] = {3, 5, 4, 1, 9}
Output: Minimum element is: 1
        Maximum element is: 9

Input: arr[] = {22, 14, 8, 17, 35, 3}
Output:  Minimum element is: 3
        Maximum element is: 35
*/

import java.util.Arrays;

public class Problem_02_Maximum_and_Minimum_Element_in_an_Array{
    public static void main(String[] args) {
        int[] arr = {22, 14, 8, 17, 35, 3};
        Arrays.sort(arr);
        System.out.println("Minimum Element is: " + arr[0]);
        System.out.println("Maximum Element is: " + arr[arr.length-1]);
    }
}