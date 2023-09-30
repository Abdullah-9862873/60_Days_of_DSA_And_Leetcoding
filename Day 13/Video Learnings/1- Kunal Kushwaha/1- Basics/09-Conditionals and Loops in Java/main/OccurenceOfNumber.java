// In the input of "138757879" find how many number of 7's are in the input.

package com.abdullah;

import java.util.Scanner;

public class OccurenceOfNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner input = new Scanner(System.in);
        int UserInput = input.nextInt();
        input.close();

        int count = 0;
        int remainder = 0;
        while (UserInput != 0) {
            remainder = UserInput % 10;
            UserInput = UserInput / 10;
            if (remainder == 7) {
                count = count + 1;
            }
        }
        System.out.println("The number of 7 in the input are: " + count);
    }
}
