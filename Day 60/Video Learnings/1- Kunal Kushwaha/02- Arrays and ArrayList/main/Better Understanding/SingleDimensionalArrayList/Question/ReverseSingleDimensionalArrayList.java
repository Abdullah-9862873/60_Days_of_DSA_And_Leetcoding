import java.util.Scanner;
import java.util.ArrayList;

public class ReverseSingleDimensionalArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>(10);

        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Enter the values of list... Enter 000 to exit: ");
            list.add(input.nextInt());
            if (list.get((list.size() - 1)).equals(000)) {
                isTrue = false;
                list.remove(list.size() - 1);
                break;
            }
        }
        input.close();

        System.out.println("Before reversing: " + list);
        // Reversing
        int start = 0; // Start index
        int end = list.size() - 1; // End index

        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start += 1;
            end -= 1;
        }

        System.out.println("After reversing: " + list);
    }
}
