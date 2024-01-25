package types.multiLevel.example;

public class Box {
    double l;
    double w;
    double h;

    Box(){
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    Box(double l, double w, double h){
        this.l = l;
        this.w = w;
        this.h = h;
    }

    Box(Box other){
        this.l = other.l;
        this.w = other.w;
        this.h = other.h;
    }

    Box(double side){
        this.l = side;
        this.w = side;
        this.h = side;
    }

    public void information(){
        System.out.println("I am box");
    }
}
