public class Part_31_Constructors_and_This {
    public static class Person{
        int age;
        String name;

        void sayHi(){
            System.out.println(name + "[" + age + "]" + " says hi");
        }

        // If we forget then java provides its own constuctor
        // A constructor is a function that has the same name like the class name
        Person(){
            // This is a constructor and is invoked when new Person() will get called... Look how Person() gets called using brackets
            // This is a default constructor
        }

        Person(int age, String name){
            // This is parameterized constructor
            this.age = age;     // here this.age is the age of this class... And the age after equal is the age that is being passed in this from the main class...
            // Now when the parameters are passed then in stack age,name and this will get passed... this will be automatically passed and "this" is basically reference of class p2 in this case lets say 5k... so this.age is basically 5k.age and this.name is basically 5k.name...
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";
        p1.sayHi();

        Person p2 = new Person(20, "B");
        p2.sayHi();
    }
}

/*
-------------Notes-------------
----> When new Person() gets hit then a space gets allocated in the heap memory... The amount of space allocated depends on the variables of the class... In this case int age and string name...

----> The code is executed in three steps
1) Space Allocation
2) Parsing
3) Constructos called


1) So when a new class is made then space allocation is done like the space that is needed to store int age and String name will get allocated in the heap memory

2) The parsing is done so parsing is basically the execution of all the stuff except the functions and the constructor in the class... so here in the Person class when parsing is done then age will get assigned 0 and name will get assigned null... But if you have written like age = -1 then age would have been assigned -1...

3) Then constructors are called and values that are passed or set in the main function will get allocated to the instances...
 */