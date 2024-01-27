package Types.runtime_or_dynamic_polymorphism.example.example1;

public class Circle extends Shapes{
    @Override // This is an annotation and is used to represent that the method is being overriden... 
    void area(){
        System.out.println("Area is pie * r * r");
    }
}
