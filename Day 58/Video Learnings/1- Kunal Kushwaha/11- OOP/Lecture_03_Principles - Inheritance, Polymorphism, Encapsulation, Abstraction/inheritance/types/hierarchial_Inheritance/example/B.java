package types.hierarchial_Inheritance.example;

public class B extends Box{
    double weight;

    public B(){
        this.weight = -1;
    }

    public B(double weight){
        this.weight = weight;
    }

    public B(B other){
        super(other);
        this.weight = other.weight;
    }

    public B(double l, double w, double h, double weight){
        super(l,w,h);
        this.weight = weight;
    }
}
