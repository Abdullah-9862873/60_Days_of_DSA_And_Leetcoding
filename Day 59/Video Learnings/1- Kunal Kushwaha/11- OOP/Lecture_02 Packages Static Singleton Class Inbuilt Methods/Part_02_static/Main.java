public class Main{
    public static void main(String[] args) {
        /*
        The following will create two humans and works fine... (At this point we have no "population" variable in the Human class btw)... What if we have a variable that is same for all human beings i-e lets say population... Now this population must be same for all Humans... So we can observe that this "population" cannot be something that vary for Human to Human... So it should be something that is independent of objects i-e Humans... 
        This is where static comes in, static is something that is independent of objects...
        */
        // Human human1 = new Human(21, "Abdullah", 10000,false);
        // Human human2 = new Human(20, "Ahmed", 20000,true);

        // System.out.println(human1.name);
        // System.out.println(human2.name);


        // System.out.println(Human.population);


        /*
        The following will throw an error because you cannot access a non-static function inside a static function
        */
        // greeting();

        /*
        Following, you can access here because its declared static
        */
        // fun();


        /*
        Following is the way to access non-static stuff inside a static function:
        */
        // Main obj = new Main();
        // obj.greeting();


        /*
        Following is the way to run fun2 function here
        */
        // Main obj = new Main();
        // obj.fun2();


    }

    void greeting(){
        /*
        You can access a static stuff inside a non-static stuff because its not limitising it... Like fun() used in this function
        */
        System.out.println("Hello ");
        fun();
    }

    static void fun(){
        System.out.println("I am having fun");

        /*
        You can run greeting in the following way
        */
        Main obj = new Main();
        obj.greeting();
    }

    void fun2(){
        greeting();
    }
    
}

class Human{
    int age;
    String name;
    int salary;
    boolean married;
    static long population;

    public Human(int myAge, String myName, int mySalary, boolean maritalStatus){
        this.age = myAge;
        this.name = myName;
        this.salary = mySalary;
        this.married = maritalStatus;
        Human.population += 1;
    }
}


/*
____________________________________________________________________
What is static??


----> Let's say I have the following class
class Human{
    int age;
    String name;
    int salary;

    Human(int age, String name, int salary){
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
}

----> Let's say that there is a characteristic or a property of this class that is not actually related to that object... So for example, let this class has a property called "population"... Does it actually related to the obj... That Obj1 has population of human 7Billion and obj2 has population of human 5Billion... The answer is No... Population will be same for both objects so in this case we create a property using the static keyword... And if you have used static keyword to create an instance variable let's say population then you don't have to use "this" keyword, as it is not specified to that particular object only... So we use the class name...

----> For example

class Human{
    int age;
    String name;
    int salary;
    static long population;

    Human(int age, String name, int salary){
        this.age = age;
        this.name = name;
        this.salary = salary;
        Human.population += 1;
    }
}

----> The above class will initialise the population as zero as this is the default value of the long and will keep on adding 1 as new objects are being created so if you do like the following then you will get an answer 2 for both objects...

        Human one = new Human(21, "Abdullah", 10000);
        Human two = new Human(34, "Ahmed", 12000);

        System.out.println(one.population);
        System.out.println(two.population);

----> So basically static variable is common to every object of that class
----> Static instance variables are not dependent on any object declation or initialisation... 
----> And if you don't make any object of that class then still you can access the static instance variable... For example, you can do something like not creating any object of Human class but accessing the population like:
System.out.println(Human.population);


----> Question: Why do we make "public static void main(String[] args)", why do we use static in it?

----> Answer: So basically the "psvm" is present inside a class "Main" and static variables or functions are those which are independent of the creation of objects of the class... In java, you cannot run anything if you dont have "main()" so if the main if the first thing you have to run, so if the main() is not static then we have to run another program first to make object of class and run main() via that object... But since none of the program can be run before main() so main() is declared as static...

____________________________________________________________________
#### IMPORTANT ####
-----> Inside a static method, you cannot use anything that is not static... Becauise how can you put something that is dependent on the creation of objects inside something that is independent on the creation of objects... This is the reason that whatever functions we create in java, we make them static...

____________________________________________________________________
How to access a non static function or variable inside a static function??

---> The fact is that, YOU CANNOT ACCESS A NON-STATIC STUFF IN A STATIC CONTEXT UNLESS YOU MAKE THE INSTANCE OF THAT NON-STATIC STUFF IN THAT STATIC STUFF...

For Example

we have something like 

public class Main{
    void greeting(){
        System.out.println("I am greeting");
    }
    static void fun(){
        System.out.println("I am fun");
    }
}

Here, if you want to access greeting() in fun like:
static void fun(){
    System.out.println("I am fun");
    greeting();
}

It will throw an error so you have to make an instance of non-static stuff(greeting) in a static stuff(fun) to make it work so the final will be:

Since greeting() is the part of Main class so instance of Main class must be created...

    public class Main{
        void greeting(){
            System.out.println("I am greeting");
        }
        static void fun(){
            System.out.println("I am fun");
            Main obj = new Main();
            obj.greeting();
        }
    }
____________________________________________________________________
    What if we have a situation in which non-static function is present inside non-static function... 
    
    public class Main{
        public static void main(String[] args){
            Main obj = new Main();
            obj.fun();
        }
        void fun(){
            greeting();
        }
        void greeting(){
            System.out.println("I am greeting");
        }
    }
    
    To make it work we have to create an object of their parent class in the main()... Now the non-static function inside the fun() will also get cared of automatically...
___________________________________________________________________
Why you can't use "this" keyword inside a static context??

---> "this" represents an object, while static is something that is independent of objects and can be directly called via class name... So you cant have something depending on object inside something that is independent...
    
____________________________________________________________________
---> The thing is, overriding depends on objects, static does not depend on objects, hence static methods cannot be overriden...
*/