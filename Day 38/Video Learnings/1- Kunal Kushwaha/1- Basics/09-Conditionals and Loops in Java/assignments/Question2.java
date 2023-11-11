/*

Write a program to print the sum of negative numbers, sum of positive even numbers and the sum of positive odd numbers from a list of numbers (N) entered by the user. The list terminates when the user enters a zero.

*/

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sumNegative = 0;
        int sumPositiveOdd = 0;
        int sumPositiveEven = 0;

        System.out.println("Enter any number... Enter 0 to exit");
        int num = input.nextInt();
        while(num != 0){
            if(num < 0){
                sumNegative += num;
            }else if((num > 0) && (num % 2 == 0)){
                sumPositiveEven += num;
            }else if((num > 0) && (num % 2 != 0)){
                sumPositiveOdd += num;
            }
            System.out.println("Enter any number... Enter 0 to exit");
            num = input.nextInt();
        }
        input.close();
        System.out.println("Sum of Negative numbers is: " + sumNegative);
        System.out.println("Sum of Positive even numbers is: " + sumPositiveEven);
        System.out.println("Sum of Positive odd numbers is: " + sumPositiveOdd);
    }
}
