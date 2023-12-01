package com.abdullah;

import java.util.Scanner;

public class Typecasting {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // int value1 = input.nextInt();
        // System.out.println(value1);
        // input.close();

        // TypeCasting
        // System.out.println("Enter the value: ");
        // Scanner input = new Scanner(System.in);
        // float num = input.nextFloat();
        // // Converting num into integer
        // int num1 = (int) num;
        // System.out.println("The value you entered is: " + num1);
        // input.close();

        // Automatic Type Promotion in Expression
        // int num = 257;
        // byte num2 = (byte) (num);
        // System.out.println(num2);

        // byte a = 20;
        // int b = (a * 120);
        // System.out.println(b);
        // byte c = (byte) (b);
        // System.out.println(c);

        // Find the Ascii value of a character
        // System.out.println("Enter the character you wanna find the ASCII code of: ");
        // Scanner input = new Scanner(System.in);
        // char firstChar = input.next().charAt(0);
        // input.close();
        // int firstCharValue = (int) firstChar;
        // System.out.println("The ASCII value of " + firstChar + " is: " +
        // firstCharValue);

        // The following will convert it into integer value

        // char firstChar = 'a';
        // int a = firstChar * 1;
        // System.out.println(a);

        // byte b = 42;
        // char c = 'a';
        // short s = 1024;
        // int i = 10000;
        // float f = 5.67f;
        // double d = 0.1234;
        // double result = (f * b) + (i / c) + (d * s);
        // // The answer will be in Double as -----> (float) + (Integer) + (Double) --->
        // // Double
        // System.out.println(result);
        // // To find the type of "result"
        // Class<? extends Double> resultClass = Double.valueOf(result).getClass();
        // System.out.println(resultClass.getName());


    }

}

/*
 * ------------> If you write like the following
 * 
 * float num = input.nextFloat();
 * 
 * ------------>But you give it an input of integer then it will automatically
 * convert the
 * integer to float
 * 
 * -------------> But if you write like the following
 * 
 * int num = input.nextFloat();
 * 
 * -------------> It will throw an error and the reson is that now the left side
 * is smaller than the right side. The right side must be large in order to let
 * the typecasting to automatically happen.
 * 
 * --------------> If you write like the following and enter the floating number
 * int value1 = input.nextInt();
 * 
 * --------------> Then it will throw an error as the integer is smaller than
 * the float.
 * 
 * --------------> But if you write like the following and enter the integer
 * value
 * float value2 = input.nextFloat();
 * 
 * --------------> Then it will not throw and error rather it will convert the
 * integer to float automatically
 * 
 * 
 * ----------------------------------------------------------------------------
 * 
 * ---------------> If you write the following code:
 * 
 * byte d = 50;
 * d = d * 2;
 * System.out.println(d)
 * 
 * It will throw an error that "Cannot convert from int to byte" this is because
 * while calculating it will automatically convert it to integer and then
 * perform the multiplication operation on the integer rather than the byte.
 * 
 * ---------------->Consider the following example tooo
 * 
 * byte a = 20;
 * byte b = 40;
 * byte c = 100;
 * int d = (a*b)/c;
 * Now here the "a*b" is being done while both "a" and "b" are integers not the
 * byte
 * 
 * 
 * ---------Rules_Being_Followed_By_Java_Program-----------
 * 1---> All the Byte, Short and Character valeus are promoted to integers.
 * 2---> Any one of the operands is long then the whole operation is converted
 * to long.
 * 3---> Any on of the operands is float then the whole operation is converted
 * to float.
 * 4---> Any on of the operands is double then the whole operation is converted
 * to double.
 * 
 * Example:--------> In the following code:
 * System.out.println(3 * 5.6)
 * 
 * Output-----------> 16.79999999
 * 
 */