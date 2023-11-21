/*
Given an array, rotate the array by one position in clock-wise direction.
 

Example 1:

Input:
N = 5
A[] = {1, 2, 3, 4, 5}
Output:
5 1 2 3 4
*/

import java.util.Arrays;

public class Problem_07_Cyclic_Rotate_an_Array_by_one{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int n = arr.length;

        int pt1 = 0;
        while(pt1 < n-1){
            swap(arr, pt1, n-1);
            pt1++;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}