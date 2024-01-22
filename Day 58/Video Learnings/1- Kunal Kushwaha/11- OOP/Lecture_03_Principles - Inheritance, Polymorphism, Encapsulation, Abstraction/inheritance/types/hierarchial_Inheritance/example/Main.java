package types.hierarchial_Inheritance.example;

public class Main {
    public static void main(String[] args) {
        A obj1 = new A(12,13,14,15);
        System.out.println(obj1.l + " " + obj1.w + " " + obj1.h + " " + obj1.price);
    }
}


/*
________________To run___________________
----> Go to the directory inheritance\types\hierarchial_Inheritace\example
----> Enter the command, "javac Main.java Box.java A.java B.java C.java"
----> Go outside the inheritance directory by doing cd.. 
----> Enter the command, "java -cp . inheritance.types.hierarchial_Inheritace.example.Main"

*/
