package example.package1;

public class Main {
    public static void main(String[] args) {
        A obj = new A(12, "Abdullah", 3400);
        System.out.println(obj.getNum());
    }
}

/*
____________________________To run____________________________
----> Go inside the directory example and run the command "javac Main.java A.java"
----> Come outside the directory but stay inside the "access_control" and type the following command... "java -cp . example.package1.Main"
*/
