package com.main;

public class LinearSearchInString {
    public static void main(String[] args) {
        String name = "Abdullah";
        char target = 'b';

        boolean check = search(name, target);
        System.out.println(check);
    }

    static boolean search(String name, int target) {
        if (name.length() == 0) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == target) {
                return true;
            }
        }
        return false;
    }
}
