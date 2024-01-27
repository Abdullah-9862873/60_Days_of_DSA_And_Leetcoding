package example1;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(23);
        Daughter daughter = new Daughter(20);

        son.career();
        daughter.career();

        
    }
}

/*
_______________________TO RUN_________________________
---> Go inside the directory of example1 in the terminal and compile the file by "javac Main.java Parent.java Daughter.java Son.java"
---> Go outside the directory of example1 and give command "java -cp . example1.Main"

___________________Can't create objects of abstract class_______________
---> You cannot create the objects of abstract class like the following:
Parent mom = new Parent();

This will give error... Rather following is what you can do:
Parent mom = new Parent(){
        @Override
        void career() {
            
        }

        @Override
        void partner() {
            
        }
}

So you have to override all the abstract methods in the main while creating the object of an abstract class...

_________________________Use of Abstract class____________________
----> When you are sure that the child classes are eventually gonna have the body of a method then you can make that method an abstract method in the parent class...


*/
