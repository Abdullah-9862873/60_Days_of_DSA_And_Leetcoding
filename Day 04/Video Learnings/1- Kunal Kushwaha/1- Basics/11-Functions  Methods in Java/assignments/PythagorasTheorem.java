/*
Write a function to check if a given triplet is a Pythagorean triplet or not. (A Pythagorean triplet is when the sum of the square of two numbers is equal to the square of the third number).
*/

import java.util.Scanner;

public class PythagorasTheorem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of a: ");
        int a = input.nextInt();

        System.out.println("Enter the value of b: ");
        int b = input.nextInt();

        System.out.println("Enter the value of c: ");
        int c = input.nextInt();
        input.close();

        if(isPythagoras(a, b, c)){
            System.out.println("Yes it is a Pythagoras triplet");
        }else{
            System.out.println("No it's not a Pythagoras triplet");
        }
    }

    public static boolean isPythagoras(int a, int b, int c){
        if((a*a + b*b) == (c*c)){
            return true;
        }else if((a*a + c*c) == (b*b)){
            return true;
        }else if((b*b + c*c) == (a*a)){
            return true;
        }
        return false;
    }
}
