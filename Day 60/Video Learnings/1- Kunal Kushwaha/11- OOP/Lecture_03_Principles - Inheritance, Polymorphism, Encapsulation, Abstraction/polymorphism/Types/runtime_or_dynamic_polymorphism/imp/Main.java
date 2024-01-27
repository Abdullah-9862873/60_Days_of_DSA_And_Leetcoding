// Its the example of static method overriding
package Types.runtime_or_dynamic_polymorphism.imp;

public class Main {
    public static void main(String[] args) {
        Box obj = new BoxWeight();
        obj.greeting();
    }
}


/*
___________________NOTES___________________
__________________________Static methods cannot be overriden___________________
----> This will print the "greeting" method from "Box" class...  

---> It is showing this behavior because when the methods are static then which method to run is determined at compile time based on the reference type rather than runtime based on the Object type...

---> The thing is, overriding depends on objects, static does not depend on objects, hence static methods cannot be overriden...

___________________What is Method Hiding?______________________
In Java, static methods cannot be overridden in the same way as instance variables. When you declare a method as static in a class and then redeclare a method with the same name in a subclass, it's not considered overriding; instead, it's called method hiding.

---> Method hiding is associated with the concept that the methods are hidden in such a way that which method will run will get decided on compile time rather than runtime and depends on the type of reference variable now... This is achieved by making two static methods with the same name in base and derived classes...

*/
