package staticExample;

public class Main {
    public static void main(String[] args) {
        // Human abdullah = new Human(21, "Abdullah", 10000, false);
        // Human ahmed = new Human(25, "Ahmed", 20000, false);

        // System.out.println(abdullah.population);
        // System.out.println(ahmed.population);

        System.out.println(Human.population);
        Human.message();
        fun();
    }

    static void fun(){
        System.out.println("I am having fun");

        // You cannot use greeing inside this because "fun" is static and "greeting" is non-static

        // In order to use "greeting" inside it you have to create an object
        Main obj = new Main();
        obj.greeting();
    }

    void greeting(){
        System.out.println("Hey there");
    }
}


/*
To run the main file
---> Go to the terminal and type "cd staticExample"
---> After that, compile the files by "javac Human.java Main.java"
---> After that, come back to main directory by "cd.."
---> After that, run the Main by "java -cp . staticExample.Main"
*/


// _______________________________________________________________
/*
______________________NOTES______________________

____________Static variables can be accessed without object creations__________
-----> You can access any static variable present within the class via the class name without having to create any instance of that class...
-----> Example in this case, System.out.println(Human.population);


______________Why main class is declared as static______________________
----> We know that in java, Main is the very first thing that is run... And if the main is not declared as static, that means that main function now depends on creation of an object of "Main" class... And if main function is the very first thing that is run in java program how can we make an program an object of "Main" class and access "main" function via that object... Hence, "main" function is declared as static...

___________Non-static method cannot be present in a static context_________
----> If the greeting method is not static then it cannot be called inside the main method... This is because "main" is static and does not depend on the creation of any instance and then being called via dot operator... However greeting is non-static that means it depends on the creation of an instance and being called via that instance... Hence static context can only have static methods...


*/