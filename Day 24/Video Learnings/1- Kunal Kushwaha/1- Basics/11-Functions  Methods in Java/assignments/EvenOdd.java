package com.assignments;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number you want to check: ");
        int userInput = input.nextInt();

        input.close();

        isEven(userInput);
    }

    static void isEven(int num) {
        boolean isEven = false;
        if (num == 0) {
            isEven = true;
        } else if (num % 2 == 0) {
            isEven = true;
        }

        if (isEven) {
            System.out.println("The number you entered is Even");
        } else {
            System.out.println("The number you entered is Odd");
        }
    }

}
