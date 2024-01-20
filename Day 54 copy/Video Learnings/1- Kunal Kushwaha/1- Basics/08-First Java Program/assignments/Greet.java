
package com.assignments;

import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {
        System.out.println("Enter your name please: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        input.close();
        System.out.println("Hello " + name);
    }
}