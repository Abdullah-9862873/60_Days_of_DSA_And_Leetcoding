import java.util.Scanner;

public class PowerInJava{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the num: ");
        int num = input.nextInt();

        System.out.println("Enter the power");
        int power = input.nextInt();

        input.close();
        int ans = 1;

        for(int i=1; i<=power; i++){
            ans = ans * num;
        }

        System.out.println(ans);

    }
}