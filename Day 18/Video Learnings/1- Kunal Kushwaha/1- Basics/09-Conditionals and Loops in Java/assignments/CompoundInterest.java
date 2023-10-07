import java.util.Scanner;

public class CompoundInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the initial amount of money you are investing or borrowing... Principal: ");
        int Principal = input.nextInt();

        System.out.println("Enter the rate at which the investment or loan earns interest, in percentage... Interest Rate: ");
        double rate = input.nextDouble();

        // Converting rate from percentage to decimal
        rate = rate / 100;

        System.out.println("Enter the total number of years: ");
        int n = input.nextInt();

        System.out.println("Enter the compounding frequency: ");
        int freq = input.nextInt();

        input.close();

        double interest = Principal * ((Math.pow((1 + rate/freq), (n*freq))));

        // System.out.println("Compound Interest is: " + interest);
        System.out.println("So, after " + n + " years with a compounding frequency of " + freq + " your investment of $" + Principal + " will grow to approximately $" + interest + ", earning a compound interest of $" + (interest - Principal) + ".");
    }
}
