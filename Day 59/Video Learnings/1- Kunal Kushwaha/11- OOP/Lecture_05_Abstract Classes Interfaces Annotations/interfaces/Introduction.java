
/*
_______________________________NOTES_______________________________
---> Interfaces are more concerned about what the class is doing rather how its doing... i-e High level design

_________________________PROBLEM IN MULTIPLE INHERITANCE IN JAVA_________________________
---> The problem of multiple inheritance i-e If we have class C that inherits from class "A" and class "B"... And lets say class "A" and "B" has method func()... Then if we do the following:
C c = new C();
c.fun();

Then from which superclass this fun() method will run... This problem is resolved using the interfaces...

_________________________DIFFERENCE FROM ABSTRACT CLASSES___________________
---> Unlike abstract classes, interfaces cannot have any non-abstract method... But interfaces can have default methods...
---> Variables declared in interfaces are by default final... Because since no constructor is allowed in interface so variables cannot be initialised so they are made final.
---> Multiple inheritance is allowed in interfaces and unlike other classes inheritance... The inheritance is done in interfaces by using "implements" keyword rather than "extends" keyword...

---> In Java, interfaces cannot have private or protected data members. All fields (data members) in an interface are implicitly public, static, and final
*/

