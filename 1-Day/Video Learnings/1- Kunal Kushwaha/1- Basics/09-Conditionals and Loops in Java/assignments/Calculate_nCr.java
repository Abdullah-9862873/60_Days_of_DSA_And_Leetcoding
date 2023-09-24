// nCr = n!/(r!*(n-r)!) -----> Example 5C2 = 10
package com.assignments;

import java.util.Scanner;

public class Calculate_nCr {
    public static void main(String[] args) {
        System.out.println("Enter the value of n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println("Enter the value of r: ");
        int r = input.nextInt();

        // Calculating the factorial of n
        int nFactorial = n;
        if (n == 1 || n == 0) {
            nFactorial = 1;
        } else {
            for (int i = (n - 1); i >= 1; i--) {
                nFactorial = nFactorial * i;
            }
        }

        // Calculating the factorial of r
        int rFactorial = r;
        if (r == 1 || r == 0) {
            rFactorial = 1;
        } else {
            for (int i = (r - 1); i >= 1; i--) {
                rFactorial = rFactorial * i;
            }
        }

        // Calculating the factorial of (n-r)
        int n_rFactorial = (n - r);
        if ((n - r) == 1 || (n - r) == 0) {
            n_rFactorial = 1;
        } else {
            for (int i = (n_rFactorial) - 1; i >= 1; i--) {
                n_rFactorial = n_rFactorial * i;
            }
        }

        // Putting in formula
        int ans = (nFactorial) / ((rFactorial) * (n_rFactorial));

        System.out.println("The nCr is given as: " + ans);
        input.close();
    }
}
