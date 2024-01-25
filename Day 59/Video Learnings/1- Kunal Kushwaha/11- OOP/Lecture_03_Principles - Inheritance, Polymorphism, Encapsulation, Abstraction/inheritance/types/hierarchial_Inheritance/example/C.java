package types.hierarchial_Inheritance.example;

public class C extends Box{
    boolean cheap;

    public C(){
        this.cheap = true;
    }

    public C(boolean cheap){
        this.cheap = cheap;
    }

    public C(C other){
        super(other);
        this.cheap = other.cheap;
    }

    public C(double l, double w, double h, boolean cheap){
        super(l,w,h);
        this.cheap = cheap;
    }
    
}
