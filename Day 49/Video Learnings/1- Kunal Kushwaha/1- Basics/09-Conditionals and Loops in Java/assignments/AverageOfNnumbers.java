// Calculate Average Of N Numbers
package com.assignments;

import java.util.Scanner;

public class AverageOfNnumbers {
    public static void main(String[] args) {
        System.out.println("Enter how many numbers you wanna add: ");
        Scanner input = new Scanner(System.in);
        int totalNum = input.nextInt();

        int count = 0;
        int sum = 0;

        for (int i = totalNum; i >= 1; i--) {
            System.out.println("Enter the number: ");
            int userInput = input.nextInt();
            sum = sum + userInput;
            count++;
        }

        float avg = sum / count;
        System.out.println("The average of these numbers are: " + avg);

        input.close();

    }
}
