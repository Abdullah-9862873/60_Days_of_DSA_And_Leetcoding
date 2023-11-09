// Find the HCF of two numbers
package com.assignments;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the numebr: ");
        int userInput = input.nextInt();

        boolean flag = false;
        for (int i = 2; i <= Math.sqrt(userInput); i++) {
            if (userInput % i == 0) {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("It is not a prime number");
        } else {
            System.out.println("It is a prime number");
        }

        input.close();

    }
}
