/*
An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.

Examples : 

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
*/

import java.util.Arrays;

public class Problem_5_Move_all_negative_numbers_to_beginning_and_positive_to_end {
    public static void main(String[] args) {
        int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };

        int pt1 = 0;
        int pt2 = arr.length - 1;
        while (pt1 < pt2) {
            // pt1 will get stopped when it lands on positive
            while (arr[pt1] < 0) {
                pt1++;
            }
            // pt2 will get stopped when it lands on negative
            while (arr[pt2] > 0) {
                pt2--;
            }

            if (pt1 < pt2) {
                swap(arr, pt1, pt2);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}