package com.main;

import java.util.Arrays;

public class UseForEachLoopInString {
    public static void main(String[] args) {
        String name = "Abdullah";
        char target = 'a';

        System.out.println(Arrays.toString(name.toCharArray()));

        boolean check = search(name, target);
        System.out.println(check);
    }

    static boolean search(String name, char target) {
        if (name.length() == 0) {
            return false;
        }

        for (char c : name.toCharArray()) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }
}
