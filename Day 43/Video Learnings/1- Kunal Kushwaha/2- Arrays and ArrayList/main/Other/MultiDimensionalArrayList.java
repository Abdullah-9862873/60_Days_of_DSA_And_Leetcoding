import java.util.ArrayList;
import java.util.Scanner;

public class MultiDimensionalArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(10);

        // By default the value of all the indexes in this list will be null so we have
        // to initialise it
        // To give three indexes or three internal lists we can write
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

        // input in multidimensional array lists
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                list.get(i).add(input.nextInt());
            }
        }
        input.close();

        // Output
        System.out.println(list);

    }
}