package com.assignments;

import java.util.Scanner;

public class EligiilityCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = input.nextInt();

        input.close();

        isEligible(age);
    }

    static void isEligible(int num) {
        boolean eligible = false;
        if (num >= 18) {
            eligible = true;
        }

        if (eligible) {
            System.out.println("You are Eligible");
        } else {
            System.out.println("You are not Eligible");
        }
    }
}
