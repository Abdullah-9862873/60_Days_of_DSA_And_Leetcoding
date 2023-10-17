import java.util.Scanner;

public class CalculateDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter actual price of product: ");
        int actualPrice = input.nextInt();

        System.out.println("Enter discount in percentage: ");
        float discount = input.nextFloat();

        input.close();

        float finalPrice = 0;
        finalPrice = finalPriceCalculator(actualPrice, discount, finalPrice);

        System.out.println("Final Price of the product is: " + finalPrice);
    }   
    public static float finalPriceCalculator(int actual, Float discount, float finalPrice){
        discount = actual * (discount / 100);
        finalPrice = actual - discount;
        return finalPrice;
    }
}
