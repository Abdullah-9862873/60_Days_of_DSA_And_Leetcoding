// Keep taking input from user till he presses X or x
package com.abdullah;

import java.util.Scanner;

public class PressingX {
    public static void main(String[] args) {
        int ans = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter an operator: ");
            char ch = input.next().trim().charAt(0);
            if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '%') {
                // Take two numbers
                System.out.println("Please Enter first value");
                int num1 = input.nextInt();
                System.out.println("Please Enter second value");
                int num2 = input.nextInt();

                if (ch == '+') {
                    ans = num1 + num2;

                } else if (ch == '-') {
                    ans = num1 - num2;
                } else if (ch == '*') {
                    ans = num1 * num2;
                } else if (ch == '/') {
                    if (num2 != 0) {
                        ans = num1 / num2;
                    } else {
                        System.out.println("The divisor is zero so can't divide");
                    }
                } else if (ch == '%') {
                    ans = num1 % num2;
                }
                System.out.println("The answer is: " + ans);
                System.out.println(
                        "Do you want to perform any other calculation? If yes then please enter Y otherwise N");
                char newChar = input.next().trim().charAt(0);
                if (newChar == 'N' || newChar == 'n') {
                    break;
                } else {
                }
            } else if (ch == 'X' || ch == 'x') {
                System.out.println("Exiting....");
                break;
            } else {
                System.out.println("Not a valid operator");
            }
        }
        input.close();
    }
}