package com.main;

// If the array is sorted then it must click on the mind to use binary search
public class BinarySearchIntro {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18 };

        int target = 14;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;    // If we do mid = (start + end)/2 ----> Then lets say we have a very large start and end.... In that case the start + end will exceed the range of int... So a better way to do this is (start + (end - start) / 2)

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else if (target == arr[mid]) {
                return mid;
            }
        }
        return -1;
    }
}