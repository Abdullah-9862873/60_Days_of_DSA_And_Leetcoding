package com.main;

public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = { 18, 12, -7, 3, 14, 28 };

        // Search for 3 in range from [1,4] index
        int start = 1;
        int end = 4;
        int target = 3;
        boolean check = searchInRange(arr, start, end, target);
        System.out.println(check);
    }

    static boolean searchInRange(int arr[], int start, int end, int target) {
        if (arr.length == 0) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }
}
