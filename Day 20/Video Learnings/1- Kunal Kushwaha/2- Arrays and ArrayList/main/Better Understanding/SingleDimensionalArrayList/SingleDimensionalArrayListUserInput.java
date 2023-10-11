package SingleDimensionalArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleDimensionalArrayListUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many values you want in your list: ");
        int size = input.nextInt();

        ArrayList<Integer> list = new ArrayList<>(size);
        int i = 0;
        while (i < size) {
            System.out.println("Enter the value: ");
            list.add(input.nextInt());
            i++;
        }

        System.out.println(list);
        input.close();

    }
}
