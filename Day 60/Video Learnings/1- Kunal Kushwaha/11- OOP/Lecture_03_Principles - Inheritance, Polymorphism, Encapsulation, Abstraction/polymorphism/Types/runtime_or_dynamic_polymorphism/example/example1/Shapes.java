package Types.runtime_or_dynamic_polymorphism.example.example1;

public class Shapes{
    void area(){
        System.out.println("I am in shapes");
    }
}


/*
____________________final methods cannot be ovverriden__________________________
----> If we put "final" keyword before this function then it will give error because final methods cannot be overriden...

----> This is because we know that what is overriding? Its basically providing different implementation of same method... But making a method final means that the implementation cannot be changed by any subclass so thats why final methods cannot be overriden...

_________________What is early binding and late binding?__________________________
----> When a method in parent class is made final, then it means that its implementation is final and cannot be changed, hence during compile time it is decided that this method cannot be implemented in any other ways by any derived class... This early findings of compiler is known as early binding...

----> When a method is overriden, then which method to run is decided on runtime after the compilation and stuff, this late determining of which method to run is known as late binding...

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
*/
