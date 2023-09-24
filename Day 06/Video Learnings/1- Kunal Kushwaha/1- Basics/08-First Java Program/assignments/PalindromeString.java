// To find out whether the given String is Palindrome or not.
package com.assignments;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println("Enter a string with no spaces: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        input.close();

        int indexStart = 0;
        int indexEnd = userInput.length() - 1;
        boolean isTrue = true;

        if (userInput.contains(" ")) {
            System.out.println("Your string contains space!!!");
        } else {
            while (indexStart < indexEnd) {
                if (userInput.charAt(indexStart) != userInput.charAt(indexEnd)) {
                    isTrue = false;
                    break;
                }
                indexStart++;
                indexEnd--;
            }
        }

        if (isTrue) {
            System.out.println("It is a palindrome");
        } else {
            System.out.println("It is not a palindrome");
        }
    }
}