package com.abdullah;

import java.util.Arrays;

public class ArrPassingUpdation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        changeArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void changeArr(int[] arr) {
        arr[0] = 99;
    }
}

/*
 * Static is basically "Object independence"
 */
