import java.util.Scanner;

public class GreetMessage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String str = input.next();
        input.close();
        System.out.println("Hello " + str + " How you doing?");
    }   
}
