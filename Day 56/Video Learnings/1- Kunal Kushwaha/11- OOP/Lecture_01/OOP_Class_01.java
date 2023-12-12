public class OOP_Class_01 {
    public static void main(String[] args) {
        Student std1 = new Student();
        System.out.println(std1.rno);
        System.out.println(std1.name);
        System.out.println(std1.marks);

        std1.greeting();
    }

    static class Student {
        int rno;
        String name;
        float marks;

        void greeting(){
            System.out.println("Hello! My name is: " + this.name);
        }

        
        //Here is the constructor that will be run if no arguments are passed to the constructor
        // Student(){
        //     this.rno = 12;
        //     this.name = "Abdullah";
        //     this.marks = 85.5f;
        // }


        // And if 3 values are passed then this constructor will run
        Student(int roll, String naam, float marks){
            this.rno = roll;
            this.name = naam;
            this.marks = marks;
        }

        // And if two values are passed then this constructor will run
        Student(int roll, String name){
            this.rno = roll;
            this.name = name;
        }

        // Following is when you pass another object as an arguemnt to the constructor
        /*
        Example:
        Student std1 = new Student(12, "Abdullah", 89.0);
        Student std2 = new Student(std1);

        So here "this" will get replaced with std1 and "otherObject" with std2
        */
        Student(Student otherObject){
            this.rno = otherObject.rno;
            this.name = otherObject.name;
            this.marks = otherObject.marks;
        }

        // Following is the way to call another constructor by the default constructor
        /*
        For example the user has done like
        Student std1 = new Student();
        
        And you want the std1 to have default values like roll=10,name-newMan,marks=96.88

        So you can do this only by calling another constructor and passing three values in this which should have been done like
        Student std1 = new Student(10,"newMan",96.88f);

        So you can do the following to call the constructor that was accepting 3 arguemnts and assigning them, via an empty constructor

        So it is basically calling the following constructor(declared above) via an empty constructor

        Student(int roll, String naam, float marks){
            this.rno = roll;
            this.name = naam;
            this.marks = marks;
        }
        */
        Student(){
            this(10,"newMan",96.88f);
        }
    }
}


/*
_________________________________________________________
What are classes?

---> Classes are the named group of properties and functions...
---> Class is like a template of object and objects are instances of classes...

----> Class has three essential properties:
1) State of the Object      ---> Means its value from its data type
2) Identity of the Object   ---> How one obj is different from other
2) Behavior of the Object   ---> Effect of data type operations

Examples
Class: Mobile Phone
State of Object ---> Color, Storage, Model(iPhone, Samsung)
Identity of Object ---> IMEI number
Behavior of Object ---> Functions like making calls, sending msgs etc

_________________________________________________________
Terminology:

1) Instance Variable: Variables inside the class are called instance variables
2) Reference Variable: Variables that are made in the main function using the class Name like

lets say the class name is Student then in main function when we write
Student myStd1 = new Student();

Then myStd1 is a reference variable

3) Function Overloading:
Two functions with same names but different types of arguments (eg1 below) or different number of arguemnts (eg2 below) are judged at runtime and performed wisely...

eg1
func(int roll, String name){

}

func(float roll, String name){

}


eg2{
func2(int roll, String name, float marks){
    
}
func2(int roll, String name){
    
}

At runtime it is decided that which function is being called
_________________________________________________________
What is the Difference between the instances and objects??

----> myStd1.setName("Abdullah");
myStd1.setAge(20);
After these assignments, myStd1 remains an instance of the Student class, but it can also be referred to as an object because it now has specific data assigned to its attributes.

----> Every object is an instance but every instance is not an object

----> So when the reference variable of class is instantiated or initiliased then an instance is made and when specific values are assigned to the instance variables of the class then we can say that the instance is now an object of the class with its own state (values of instance variables) rather then the default state (default constructor values)...

_________________________________________________________
"new" keyword is basically allocating the memory dynamically(at runtime) and returns a reference to it


Explanation:
Student student1 = new Student();
---> This means that lets say the Student class has three instance variables (roll no, marks, name) then these will get allocated some heap memory and the reference variable student1 which is in the stack memory will start pointing to that heap memory allocation...
_________________________________________________________
"Constructor" is a function that allocates values to the variables inside the heap memory... If there is not constructor in the class then default constructor will run which assign default values based on the data types of instance variables...

For example if the constructor function is not written in the class and class has instance variables like

int rollNo;
String name;

Then if rollNo is accessed then its value will be 0 and if name is accessed then its value will be null because these are the default values of int and String variables...
____________________________________________________________________________
"this" keyword is a reference variable... Whatever is the instance name... this will be replaced to that name... For example

Student myStd1 = new Student();

Now after that whereever "this" is present in the Student class... That "this" will get replaced with myStd1 here...

so this.name will mean myStd1.name... 
____________________________________________________________________________
Now a question arises that why do we have to use new keywords to make reference variable of our own class like

Student std1 = new Student();

And why dont we have to use new keyword when we use the primitive datatypes like int etc

int a = 20;

The answer is that in Java the primitives are not objects so they are stored in static memory... On the other hand, Reference variable of classes are present in the stack memory pointing to the objects that are present in the heap memory...

*/