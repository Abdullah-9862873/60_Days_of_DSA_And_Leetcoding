package polymorphism.Types.runtime_or_dynamic_polymorphism.imp;

public class Box {

    double l;
    double w;
    double h;

    public Box(){
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    static void greeting(){
        System.out.println("Hey! I am from the Box. Greetings!!!");
    }
}
