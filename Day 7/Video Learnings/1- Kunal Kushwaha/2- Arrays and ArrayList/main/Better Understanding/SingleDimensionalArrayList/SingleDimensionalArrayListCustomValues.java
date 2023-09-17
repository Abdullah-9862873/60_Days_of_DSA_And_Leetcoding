package SingleDimensionalArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SingleDimensionalArrayListCustomValues {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Output the whole list
        System.out.println(list);

        // Output a particular element from the list
        System.out.print("Enter the position of element you want to print: ");

        System.out.println(list.get((input.nextInt()) - 1));

        // Enter an element 3 in the 2nd index and print the whole list
        System.out.println("After which position you want to enter a new element: ");
        int newPos = input.nextInt();

        System.out.println("What is the element you want to add at this position: ");
        int newVal = input.nextInt();

        list.add(newPos, newVal);

        System.out.println(list);

        input.close();
    }
}

/*
 * In list.add(index-1, value);
 * 
 * This is the correct indexing when you type 2 it would take it as 1
 */
