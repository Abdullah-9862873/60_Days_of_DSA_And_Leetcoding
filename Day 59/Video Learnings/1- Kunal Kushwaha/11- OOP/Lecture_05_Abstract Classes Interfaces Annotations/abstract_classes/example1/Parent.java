package example1;

public abstract class Parent {
    int age;

    abstract void career();
    abstract void partner();

    // Abstract constructors are not allowed
    // abstract Parent(){

    // }

    // Abstract methods cannot be static
    // public abstract static void printMe();

    public Parent(int age){
        this.age = age;
    }
}

/*
__________________________Why abstract methods cannot be static?________________
----> Since static means that the method is independent of the instances of the class and can be invoked directly with the class name... Whereas abstract means that the subclasses needs to be created for the method and that method must be implemented in those subclasses which can only be used with the instances of the subclasses... So we can observe the reliance on instances here, hence abstract classes cannot be static...

___________________Rules for abstract classes___________________
---> You can't create abstract constructors...
---> You can't create abstract static methods in this...
---> Atleast one abstract method should be present in abstract classes...
---> When one of the method is abstract then the class needs to be abstract itself...
---> You cant have a final abstract class... As the abstract class needs to be inherited and final prevent it from doing so...
*/
