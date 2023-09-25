package MultiDimensionalArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MultiDimensionalArrayListCustomInput {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(1, 2, 3, 4)));
        list.add(new ArrayList<>(List.of(5, 6, 7, 8)));
        list.add(new ArrayList<>(List.of(9, 10)));

        // output the whole 2D Array List in single line
        // System.out.println(list);

        // output the whole 2D Array List in multiple lines
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // output a particular element in the multidimensional array list
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the row: ");
        int row = input.nextInt();

        System.out.println("Enter the position of the element: ");
        int col = input.nextInt();

        System.out.println("The element is: " + list.get(row - 1).get(col - 1));
        input.close();
    }
}
