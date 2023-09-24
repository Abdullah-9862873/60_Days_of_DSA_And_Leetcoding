import java.util.Scanner;

public class CalculateCommission {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter commission value: ");
        float commission = input.nextFloat();

        System.out.println("Enter total sales: ");
        float sales = input.nextFloat();

        input.close();

        System.out.println("Total commission is: " + (commission/sales)*100);
    }
}
