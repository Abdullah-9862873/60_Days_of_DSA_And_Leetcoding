import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListIntro {
    public static void main(String[] args) {

        // _________________________________________________________
        // ArrayList<Integer> list = new ArrayList<>(10);
        // list.add(10);
        // list.add(11);
        // list.add(12);
        // list.add(13);

        // System.out.println(list);
        // _________________________________________________________

        // _____________Check if the list contains 10 in it_________
        // System.out.println(list.contains(10));

        // _______________Change the 0th index to 99___________
        // list.set(0, 99);
        // System.out.println(list);

        // _________________________________________________________

        // Input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter how many values you want to enter in the list: ");
        int limit = input.nextInt();

        System.out.println("Enter the values: ");
        ArrayList<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < limit; i++) {
            list.add(input.nextInt());
        }
        input.close();

        // Output
        // for (int i = 0; i < limit; i++) {
        // System.out.print(list.get(i) + " ");
        // }

        System.out.print(list);
    }
}
