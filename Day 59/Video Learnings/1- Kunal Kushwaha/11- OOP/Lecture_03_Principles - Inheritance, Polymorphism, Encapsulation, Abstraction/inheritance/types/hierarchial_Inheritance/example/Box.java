package types.hierarchial_Inheritance.example;

public class Box {
    double l;
    double w;
    double h;

    public Box(double l, double w, double h){
        this.l = l;
        this.w = w;
        this.h = h;
    }

    public Box(){
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    public Box(Box other){
        this.l = other.l;
        this.w = other.w;
        this.h = other.h;
    }
}
