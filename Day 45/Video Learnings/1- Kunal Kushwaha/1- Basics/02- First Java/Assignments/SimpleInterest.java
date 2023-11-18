import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of principal in dollars: ");
        int principal = input.nextInt();
        System.out.println("Enter the time in minutes: ");
        int time = input.nextInt();
        System.out.println("Enter the rate in percentage: ");
        float rate = input.nextFloat();

        input.close();

        float interest = principal*rate*time;
        System.out.println("Simple Interest is: " + interest);
    }   
}
