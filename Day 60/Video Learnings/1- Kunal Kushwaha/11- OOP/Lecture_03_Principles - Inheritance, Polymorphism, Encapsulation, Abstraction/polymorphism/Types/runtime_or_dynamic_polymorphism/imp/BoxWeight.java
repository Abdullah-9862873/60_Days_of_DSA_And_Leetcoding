package Types.runtime_or_dynamic_polymorphism.imp;

public class BoxWeight extends Box{
    double price;

    public BoxWeight(){
        super();
        this.price = -1;
    }

    static void greeting(){
        System.out.println("Hey! I am from the BoxWeight. Greetings!!!");
    }
}
