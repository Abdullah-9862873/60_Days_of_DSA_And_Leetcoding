package com.main;

public class FindMinimumNumberInEntire2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 22, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11 },
        };

        int ans = search(arr);
        System.out.println(ans);
    }

    static int search(int[][] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                min = Math.min(min, arr[i][j]);
            }
        }
        return min;
    }
}
