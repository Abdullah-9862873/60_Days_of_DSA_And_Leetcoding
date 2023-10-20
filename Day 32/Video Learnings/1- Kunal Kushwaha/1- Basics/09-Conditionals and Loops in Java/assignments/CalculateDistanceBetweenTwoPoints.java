import java.util.Scanner;

public class CalculateDistanceBetweenTwoPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of x1: ");
        int x1 = input.nextInt();
        System.out.println("Enter the value of x2: ");
        int x2 = input.nextInt();

        System.out.println("Enter the value of y1: ");
        int y1 = input.nextInt();
        System.out.println("Enter the value of y2: ");
        int y2 = input.nextInt();

        input.close();

        double distance = calcDist(x1, x2, y1, y2);

        System.out.println("Distance is: " + distance);
    }
    public static double calcDist(int x1, int x2, int y1, int y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}

/*
Point A: (2, 3)
Point B: (5, 7)

Using the distance formula:

Distance = √((5 - 2)^2 + (7 - 3)^2)
= √(3^2 + 4^2)
= √(9 + 16)
= √25
= 5
*/
