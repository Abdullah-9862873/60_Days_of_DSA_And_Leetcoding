package SingleDimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class SingleDimensionalArrayUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int[] arr = new int[size];

        // input
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the value " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        input.close();

        // output
        // Get a single element

        System.out.println(arr[0]);

        // Get all array as output
        System.out.println(Arrays.toString(arr));

    }
}