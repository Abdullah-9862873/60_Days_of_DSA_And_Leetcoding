// Start searching from the start till you find the element in the array

package com.main;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearchIntro {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Enter the values of array and press 00 to exit: ");
        int userInput = -1;
        while (userInput != 00) {
            userInput = input.nextInt();
            arrayList.add(userInput);
        }
        arrayList.remove(arrayList.size() - 1);

        System.out.println(arrayList);

        System.out.println("Enter the value to find in the array: ");
        int target = input.nextInt();

        // Converting arrayList to array
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }

        input.close();
        // boolean check = linearSearch(arr, userInput);
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                check = true;
                break;
            }
        }
        System.out.println(check);
    }

}