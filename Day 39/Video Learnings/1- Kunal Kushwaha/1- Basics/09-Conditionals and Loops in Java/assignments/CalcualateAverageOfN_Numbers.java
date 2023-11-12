import java.util.Scanner;

public class CalcualateAverageOfN_Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers you want to enter: ");
        int limit = input.nextInt();
        int sum = 0;

        for(int i=1; i<=limit; i++){
            System.out.println("Enter number " + i + " : ");
            sum += input.nextInt();
        }
        input.close();

        float ans = sum / limit;
        System.out.println("Average is: " + ans);
    }
}
