import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the limit of Fibonacci Series: ");
        int n = input.nextInt();

        input.close();

        printFibSeq(n);
    }

    public static void printFibSeq(int num){
        int i=0; 
        int j=1;
        int k;

        System.out.print(i + " ");
        System.out.print(j + " ");

        for(int l=0; l<=num-3; l++){
            k = i+j;
            System.out.print(k + " ");
            i = j;
            j = k;
        }
    }
}
