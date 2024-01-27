package example1;

public abstract class Parent {
    int age;    // implicitly default access modifier

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
---> Abstract classes can have constructors, but they cannot be instantiated directly.
Example:
public abstract class AbstractShape {
    private String color;

    // Constructor for initializing the color of the shape
    public AbstractShape(String color) {
        this.color = color;
    }

    // Abstract method that must be implemented by subclasses
    public abstract double calculateArea();

    // Getter method for accessing the color
    public String getColor() {
        return color;
    }
}

public class Circle extends AbstractShape {
    private double radius;

    // Constructor for initializing the circle with a radius
    public Circle(String color, double radius) {
        super(color);  // Call the constructor of the superclass (AbstractShape)
        this.radius = radius;
    }

    // Implementation of the abstract method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle myCircle = new Circle("Red", 5.0);
        System.out.println("Color: " + myCircle.getColor());
        System.out.println("Area: " + myCircle.calculateArea());
    }
}

This is allowed but following is not allowed:
AbstractShape shape = new AbstractShape("Blue");  // Compilation error



---> You can't create abstract static methods in this...
---> Atleast one abstract method should be present in abstract classes...
---> When one of the method is abstract then the class needs to be abstract itself...
---> You cant have a final abstract class... As the abstract class needs to be inherited and final prevent it from doing so...
---> Implicitly the variables declared in abstract classes are default(package-private) but you can use access modifiers like public, private, or protected.... Same case with methods
*/
