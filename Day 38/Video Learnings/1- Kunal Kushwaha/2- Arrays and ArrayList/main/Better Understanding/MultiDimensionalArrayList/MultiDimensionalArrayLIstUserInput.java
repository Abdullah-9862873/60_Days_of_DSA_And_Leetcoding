package MultiDimensionalArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiDimensionalArrayLIstUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter how many array lists you want in your outer ArrayList: ");
        int noOfAl = input.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(10);

        // initialization
        for (int i = 0; i < noOfAl; i++) {
            list.add(new ArrayList<Integer>());
        }

        // input
        for (int i = 0; i < noOfAl; i++) {
            System.out.println("Enter how many array lists you want in you ArrayList " +
                    (i + 1) + ": ");
            int col = input.nextInt();

            for (int j = 0; j < col; j++) {
                list.get(i).add(input.nextInt());
            }
        }

        // output the whole 2D Array List
        for (ArrayList<Integer> al : list) {
            System.out.println(al);
        }

        // Output a particular element in Multidimensional Array list
        System.out.println("Enter the row in which your desired element is present: ");
        int outputRow = input.nextInt();

        System.out.println("Enter the position in row" + outputRow + ": ");
        int outputCol = input.nextInt();

        System.out.println("The element is " + (list.get(outputRow - 1).get(outputCol - 1)));
        input.close();

    }
}
