package com.abdullah;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // System.out.print("Hello World");
        System.out.println("Hello World");
        Scanner input = new Scanner(System.in);
        // System.out.println(input.nextInt());
        // System.out.println(input.next());
        System.out.println(input.nextLine());
        input.close();
    }
}

/*
 * Notes
 * 
 * <-----------------------------Output---------------------------------------->
 * 
 * --------> What System.out.println is achieving is that the "System" is
 * basically a class that the java people have written and the "out" is the
 * variable inside it. Now this "out" is of type "printStream" and that
 * "printStream" has a method called "println" which is used to print the
 * output. "Sytem.out" is the standard output stream.
 * 
 * ---------> To prevent the print function to print a new line you simply have
 * to write "System.out.print("Hello World")"
 * 
 * ---------> "out" is basically null by default, but if you assign a value to
 * it then it won't be null anymore and then you won't be able to use it as
 * commandline
 * 
 * <-----------------------------Input----------------------------------------->
 * -----------> To take input from user you have to use "Scanner". Now this is
 * avaiable in the utility class which needs to be imported in order to use
 * it...
 * 
 * ------------> System.in means the standard input stream
 * 
 * ------------> Scanner is basically a class that specifies the input stream
 * and using the object of this class we can take the input
 * 
 * 
 *
 * <-----------------------------InputInteger--------------------------------->
 * To input the integer you have to write input.nextInt()
 * 
 * * <-----------------------------InputString--------------------------------->
 * To input only the first word of the string till it find the space you can do
 * the following
 * input.next()
 * 
 * 
 *
 * <-----------------------------InputFullString--------------------------------
 * ->
 * To input the whole string and output it you can do the following
 * input.nextLine()
 */
