// Order agnostic means that you are only told that the array is sorted and you are not told whether it is sorted in ascending or descending order

package com.main;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        // int[] arr = { 1, 1, 4, 5, 8, 10, 11, 13, 15 };
        int[] arr = { 68, 55, 44, 30, 29, 23, 18, 11, 9, 6, 1 };
        int target = 16;

        int ans = orderAgnosticBS(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = false;
        if (arr[start] < arr[end]) {
            isAscending = true;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (isAscending) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else if (target < arr[mid]) {
                    end = end - 1;
                }
            } else if (!isAscending) {
                if (target > arr[mid]) {
                    end = end - 1;
                } else if (target < arr[mid]) {
                    start = start + 1;
                }
            }
        }
        return -1;
    }
}
