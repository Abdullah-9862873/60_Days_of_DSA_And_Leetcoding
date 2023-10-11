import java.util.Scanner;

public class CalculateElectricityBill {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your electricity consumption in kilo watt hour: ");
        float consumption = input.nextFloat();

        System.out.println("Enter the rate per kwh: ");
        float rate = input.nextFloat();

        input.close();

        float ans = consumption * rate;
        System.out.println("Your electricity bill is " + ans); 
    }
}
