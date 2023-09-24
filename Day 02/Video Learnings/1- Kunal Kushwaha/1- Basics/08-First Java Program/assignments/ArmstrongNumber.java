// To find Armstrong Number between two given number.

// A number is called Armstrong number when the sum of the nth power of each digit is equal to the given number. Example 370 ------> (3*3*3) + (7*7*7) + (0*0*0) = 370

package com.assignments;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        int tempOne = userInput;
        int tempTwo = userInput;
        input.close();

        // Counting the number of digits of userInput
        int count = 0;
        while (userInput != 0) {
            userInput = userInput / 10;
            count++;
        }
        int start = 0;
        while (start <= count) {
            userInput = userInput * 10;
            start++;
        }

        int result = 0;

        while (tempTwo != 0) {
            result += Math.pow(tempTwo % 10, count);
            tempTwo = tempTwo / 10;
        }

        if (result == tempOne) {
            System.out.println("It is an Armstrong number");
        } else {
            System.out.println("It is not an Armstrong number");
        }
    }
}
