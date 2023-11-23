import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number whose multiplication table you want: ");
        int num = input.nextInt();
        input.close();

        for(int i=1; i<=10; i++){
            System.out.println(num + " x " + i + " = " + num*i);
        }
    }    
}
