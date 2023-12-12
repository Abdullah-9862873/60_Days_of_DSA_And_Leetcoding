// You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

// A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

// Example 1:

// Input: accounts = [[1,2,3],[3,2,1]]
// Output: 6
// Explanation:
// 1st customer has wealth = 1 + 2 + 3 = 6
// 2nd customer has wealth = 3 + 2 + 1 = 6
// Both customers are considered the richest with a wealth of 6 each, so return 6.

import java.util.ArrayList;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                { 1, 7, 3 },
                { 2, 8 },
                { 6 },
                { 5, 4, 2, 8 },
                { 5, 4, 2, 8 },
        };

        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }

        // Finding which customer was with the maximum wealth

        ArrayList<Integer> customer = new ArrayList<Integer>(5);
        for (int i = 0; i < accounts.length; i++) {
            int newSum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                newSum += accounts[i][j];
            }
            if (max == newSum) {
                customer.add((i + 1));
            }
        }

        System.out.println("The richest customer wealth is: " + max);
        System.out.println("Follwoing are the richest customers: ");
        System.out.println(customer);

        // _______________________________________________________________________________

        // Finding which customer was with the maximum wealth

        // int customer = 0;
        // for (int i = 0; i < accounts.length; i++) {
        // int newSum = 0;
        // for (int j = 0; j < accounts[i].length; j++) {
        // newSum += accounts[i][j];
        // }
        // if (max == newSum) {
        // customer = i + 1;
        // }
        // }

        // if (customer == 1) {
        // System.out.println("The " + customer + "st " + "customer is the richest
        // wealth of " + max);
        // } else if (customer == 2) {
        // System.out.println("The " + customer + "nd " + "customer is the richest
        // wealth of " + max);
        // } else if (customer == 3) {
        // System.out.println("The " + customer + "rd " + "customer is the richest
        // wealth of " + max);
        // } else {
        // System.out.println("The " + customer + "th " + "customer is the richest
        // wealth of " + max);
        // }

        // _________________________________________________________

    }
}
