package polymorphism.Types.compileTime_Or_StaticPolymorphism.example1.example1;

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

    Box(Box oldBox){
        this.l = oldBox.l;
        this.w = oldBox.w;
        this.h = oldBox.h;
    }

    public void information(){
        System.out.println("I am running");
    }
}

