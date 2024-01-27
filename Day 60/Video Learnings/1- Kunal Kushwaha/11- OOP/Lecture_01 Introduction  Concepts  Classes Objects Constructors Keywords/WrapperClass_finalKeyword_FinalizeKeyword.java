public class WrapperClass_finalKeyword_FinalizeKeyword {
    public static void main(String[] args) {
        /*
        In the following the primitive reference variable "a" when you do a. then it will not show you many options but when you do b. then it will show you many options 

        The difference is that "b" is created like an object and not a reference of primitive type variable... And objects have their own properties and functions...
        */
        int a = 20;

        Integer b = 20;
        

        /*
        swapFunc1 is only doing "Pass by value" and not "Pass by reference" so no swap will be done...

        swapFunc2 is doing "Pass by Reference" but the values will still not be swapped... Because the Integer values are all "final"
        Read abt "final" in down notes

        In objects "pass by reference" is done...
        */

        int a1 = 10;
        int a2 = 20;
        swapFunc1(a1, a2);
        System.out.println(a1 + " " + a2);
        
        Integer a11 = 10;
        Integer a22 = 20;
        swapFunc2(a11, a22);
        System.out.println(a11 + " " + a22);


        /*
        The following will throw an error because final cannot be modified

        Also by convention the final variables must be written capitalized

        ONLY TRUE FOR PRIMITIVE DATATYPES: One more thing is that you cannot do something like declaring the final variable at first and then initialising it later on because they cannot be modified so they must not be done like:
        final MYVAR;
        MYVAR = 20;

        IN CASE OF NON-PRIMITVE i-e OBJECTS: You can declare an instance at first and then initialise it like:
        final Student std1 = new Student();
        std1.name = "Abdullah"

        One more thing: When a non-primitve is final, since this is final so you cannot reassign it like the following because this will throw an error:
        final Student std1 = new Student("Abdullah");
        std1.name = "Ahmed"
        std1 = new Student("Other Name");
        Now if you print the std1.name then it will print (Other Name) as an output because only the reference variable (std1) is final but if you want to make it to something that whatever is assigned will stay assigned and cannot get re-assigned then you can do something like the following

        public static void main(String[] args) {
            final Student std = new Student("Abdullah");
            System.out.println(std.name);
            std.name = "Ahmed";
            System.out.println(std.name);
        }
    
        static class Student{
            final String name;

            Student(String name){
                this.name = name;
            }
        } 

        */

        // final int MYVAR = 10;
        // MYVAR = 20;


        /*
        The following will declare a reference of class Student (Not creating space in heap memory)... After that it will call a for loop... For loop is doing something like keeping on creating new objects in heap memory and pointing the same referece variable obj1 to the new object being created in the heap memory... So the older objects of heap memory are being freed...

        If I do not take 10000000 and take a smaller value then it will not create a load so no objects will get destroyed... So in order to make the garbage collector destroy some older freed objects we have to put pressure on it which is done by creating so much objects in heap memory via running for loop many times...
         */
        Student obj1;

        for(int i=0; i<10000000; i++){
            obj1 = new Student("Abdullah");
        }

    }

    public static void swapFunc1(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static void swapFunc2(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }
}

class Student{
    String name;
    
    Student(String name){
        this.name = name;
    }

    /*
    The following will print "Object is destroyed" everytime an object is destroyed
    */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}

/*
Notes:
__________________________________________________________
final keyword


----> "final" is a keyword, that prevents for the original content to be modified so it's like constants
____________________final methods cannot be overriden__________________________
----> If we put "final" keyword before this function then it will give error because final methods cannot be overriden...

----> This is because we know that what is overriding? Its basically providing different implementation of same method... But making a method final means that the implementation cannot be changed by any subclass so thats why final methods cannot be overriden...

_________________What is early binding and late binding?__________________________
----> When a method in parent class is made final, then it means that its implementation is final and cannot be changed, hence during compile time it is decided that this method cannot be implemented in any other ways by any derived class... This early findings of compiler is known as early binding...
In Java, early binding is associated with non-virtual methods, final methods, private methods, and static methods.
This happens when bytecode is being generated and in bytecode, memory addresses are not present rather symbolic references are present in it... 

----> When a method is overriden, then which method to run is decided on runtime after the compilation and stuff, this late determining of which method to run is known as late binding...Here those symbolic references gets resolved...

_____________________final keyword can also be used to prevent inheritance_____________
----> When a class is made final then no inheritance can be done from that class...
Example
public final class Shapes{
    void area(){
        System.out.println("I am in shapes");
    }
}

_________________Effects of making a class final________________
----> When a class is made final then implicitly all its methods are also get final...
__________________________________________________________
Finalize Keyword


Now lets say you have a reference variable ref1 in stack memory pointing to an object obj1 at heap memory... Lets say ref1 will be made pointing to obj2 which is another object at heap memory... Now the point of obj1 is over and the garbage collector will destroy it automatically...
So basically in C++, there is a destructor which allows the user to destroy the objects which are not being used in the memory anymore... But Java does not allow this, rather what java does is, that it destroys the objects or things in the memory automatically when they are not being required... And this is done via "Garbage Collector"

----> But used the finalize keyword, we can say something like "Okay java I know you won't allow me to destroy the object and stuff but when you decide to destroy it then do this thing..." So that thing which we want it to do after destruction can be specified in finalize


*/
