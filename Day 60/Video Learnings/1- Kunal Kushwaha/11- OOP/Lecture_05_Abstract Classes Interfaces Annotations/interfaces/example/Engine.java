package example;

public interface Engine {
    void start();
    void stop();
    void acc();
}

/*
___________________________NOTES___________________________
_____________________SOME FACTS_________________
---> You dont have to specify the abstract keyword before the methods since all the methods are by default abstract in interfaces
---> You dont have to specify every data member as the following
static final int num;
etc. because every data member is by default final and static in interfaces...
---> All the methods and data members are public by default in interfaces...
---> All the variables needs to be initialised where they are declared since they are final and since no constructors are allowed in interfaces...
---> Static interface methods should have a body... As being static, these methods cannot be overriden and since they cannot be overriden then how can the subclasses implement them so their implementation is done within the interfaces where they are declared...
---> Lets say a class "A" has a method which is protected... And class "B" has that method overriden inside then the access modifier of that method in class "B" can only be "protected" or something better like "public"... It can never be more restricted like "private"...
*/
