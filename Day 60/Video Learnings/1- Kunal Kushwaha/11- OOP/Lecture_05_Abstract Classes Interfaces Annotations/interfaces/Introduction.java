
/*
_______________________________NOTES_______________________________
---> Interfaces are more concerned about what the class is doing rather how its doing... i-e High level design

_________________________PROBLEM IN MULTIPLE INHERITANCE IN JAVA_________________________
---> The problem of multiple inheritance i-e If we have class C that inherits from class "A" and class "B"... And lets say class "A" and "B" has method func()... Then if we do the following:
C c = new C();
c.fun();

Then from which superclass this fun() method will run... This problem is resolved using the interfaces...

_________________________DIFFERENCE FROM ABSTRACT CLASSES___________________
---> Interfaces can have abstract methods (implicitly public and abstract)... Interfaces can have default methods (with a default implementation).
---> Variables declared in interfaces are by public static final... Because since no constructor is allowed in interface so variables cannot be initialised so they are made final.
---> Multiple inheritance is allowed in interfaces and unlike other classes inheritance... The inheritance is done in interfaces by using "implements" keyword rather than "extends" keyword...

---> In Java, interfaces cannot have private or protected data members(variables). All fields (data members) in an interface are implicitly public, static, and final

---> In Java interfaces, methods are implicitly public and abstract if you don't specify any access modifier:
public interface MyInterface {
    void printName(String name);
}
The printName method is implicitly public and abstract

---> In Java, the interface can only be public... But if the interface is nested i-e present inside a class or interface then it can be public, private, protected or default (package-private)...

*/

