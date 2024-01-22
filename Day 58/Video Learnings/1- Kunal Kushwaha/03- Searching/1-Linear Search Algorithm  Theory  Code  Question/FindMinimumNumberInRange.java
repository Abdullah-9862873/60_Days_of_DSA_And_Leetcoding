package com.main;

public class FindMinimumNumberInRange {
    public static void main(String[] args) {
        int[] arr = { 18, 12, -7, 3, 14, 28 };

        int start = 0;
        int end = 5;

        int min = findMinSearch(arr, start, end);
        System.out.println("The minimum value is: " + min);
    }

    static int findMinSearch(int[] array, int start, int end) {
        int minimum = Integer.MAX_VALUE;
        if (array.length == 0) {
            return -1;
        }

        for (int i = start; i <= end; i++) {
            minimum = Math.min(minimum, array[i]);
        }

        return minimum;
    }
}
