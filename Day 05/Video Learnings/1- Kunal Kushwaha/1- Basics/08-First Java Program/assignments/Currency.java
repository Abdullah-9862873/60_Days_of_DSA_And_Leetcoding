// Input currency in rupees and output in USD.

package com.assignments;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        System.out.println("Enter the currency in rupees: ");
        Scanner input = new Scanner(System.in);
        int ruppees = input.nextInt();

        float dollars = ruppees * 0.0038f;
        System.out.println(ruppees + " in dollars are: " + dollars);

        input.close();
    }
}
