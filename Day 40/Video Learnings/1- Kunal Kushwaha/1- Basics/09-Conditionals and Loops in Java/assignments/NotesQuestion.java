package com.assignments;

import java.util.Scanner;

public class NotesQuestion {
    public static void main(String[] args) {
        System.out.println("Enter the total amount please: ");
        Scanner input = new Scanner(System.in);
        int totalAmount = input.nextInt();
        input.close();
        int fiveThousandNotes = 0;
        int thousandNotes = 0;
        int fiveHundredNotes = 0;
        int hundredNotes = 0;
        int fiftyNotes = 0;
        int tensNotes = 0;
        int unit = 0;
        int remainder = 0;

        // Amount greater than 5000

        // 8450 ------>=
        // 3450

        if (totalAmount >= 5000) {
            fiveThousandNotes += totalAmount / 5000; // ans = 1
            remainder = totalAmount % 5000; // ans = 3450
            totalAmount -= fiveThousandNotes * 5000; // totalAmount = 3450
            if (totalAmount >= 1000) {
                thousandNotes += totalAmount / 1000; // ans = 3
                remainder = totalAmount % 1000; // ans = 450
                totalAmount -= thousandNotes * 1000;
                if (totalAmount >= 500) {
                    fiveHundredNotes += totalAmount / 500;
                    remainder = totalAmount % 500;
                    totalAmount -= fiveHundredNotes * 500;
                    if (totalAmount >= 100) {
                        hundredNotes += totalAmount / 100;
                        remainder = totalAmount % 100;
                        totalAmount -= hundredNotes * 100;
                        if (totalAmount >= 50) {
                            fiftyNotes += totalAmount / 50;
                            remainder = totalAmount % 50;
                            totalAmount -= fiftyNotes * 50;
                            if (totalAmount >= 10) {
                                tensNotes += totalAmount / 10;
                                remainder = totalAmount % 10;
                                totalAmount -= tensNotes * 10;
                            } else {
                                unit += totalAmount;
                            }
                        }
                    }

                }
            }
        }

        if (totalAmount >= 1000) {
            thousandNotes += totalAmount / 1000; // ans = 3
            remainder = totalAmount % 1000; // ans = 450
            totalAmount -= thousandNotes * 1000;
            if (totalAmount >= 500) {
                fiveHundredNotes += totalAmount / 500;
                remainder = totalAmount % 500;
                totalAmount -= fiveHundredNotes * 500;
                if (totalAmount >= 100) {
                    hundredNotes += totalAmount / 100;
                    remainder = totalAmount % 100;
                    totalAmount -= hundredNotes * 100;
                    if (totalAmount >= 50) {
                        fiftyNotes += totalAmount / 50;
                        remainder = totalAmount % 50;
                        totalAmount -= fiftyNotes * 50;
                        if (totalAmount >= 10) {
                            tensNotes += totalAmount / 10;
                            remainder = totalAmount % 10;
                            totalAmount -= tensNotes * 10;
                        } else {
                            unit += totalAmount;
                        }
                    }
                }

            }
        }

        if (totalAmount >= 500) {
            fiveHundredNotes += totalAmount / 500;
            remainder = totalAmount % 500;
            totalAmount -= fiveHundredNotes * 500;
            if (totalAmount >= 100) {
                hundredNotes += totalAmount / 100;
                remainder = totalAmount % 100;
                totalAmount -= hundredNotes * 100;
                if (totalAmount >= 50) {
                    fiftyNotes += totalAmount / 50;
                    remainder = totalAmount % 50;
                    totalAmount -= fiftyNotes * 50;
                    if (totalAmount >= 10) {
                        tensNotes += totalAmount / 10;
                        remainder = totalAmount % 10;
                        totalAmount -= tensNotes * 10;
                    } else {
                        unit += totalAmount;
                    }
                }
            }
        }

        if (totalAmount >= 100) {
            hundredNotes += totalAmount / 100;
            remainder = totalAmount % 100;
            totalAmount -= hundredNotes * 100;
            if (totalAmount >= 50) {
                fiftyNotes += totalAmount / 50;
                remainder = totalAmount % 50;
                totalAmount -= fiftyNotes * 50;
                if (totalAmount >= 10) {
                    tensNotes += totalAmount / 10;
                    remainder = totalAmount % 10;
                    totalAmount -= tensNotes * 10;
                } else {
                    unit += totalAmount;
                }
            }
        }

        if (totalAmount >= 50) {
            fiftyNotes += totalAmount / 50;
            remainder = totalAmount % 50;
            totalAmount -= fiftyNotes * 50;
            if (totalAmount >= 10) {
                tensNotes += totalAmount / 10;
                remainder = totalAmount % 10;
                totalAmount -= tensNotes * 10;
            } else {
                unit += totalAmount;
            }
        }

        if (totalAmount >= 10) {
            tensNotes += totalAmount / 10;
            remainder = totalAmount % 10;
            totalAmount -= tensNotes * 10;
        } else {
            unit += totalAmount;
        }

        System.out.println("FiveThousand Notes: " + fiveThousandNotes);
        System.out.println("Thousand Notes: " + thousandNotes);
        System.out.println("FiveHundred Notes: " + fiveHundredNotes);
        System.out.println("Hundred Notes: " + hundredNotes);
        System.out.println("Fifty Notes: " + fiftyNotes);
        System.out.println("Tens Notes: " + tensNotes);
        System.out.println("Unit Left: " + unit);

    }
}
