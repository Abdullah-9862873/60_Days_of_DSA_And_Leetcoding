package Types.compileTime_Or_StaticPolymorphism.example1;

public class BoxWeight extends Box{
    double weight;

    // First contructor
    BoxWeight(double weight){
        this.weight = weight;
    }

    // Second contructor
    BoxWeight(double l, double w, double h, double weight){
        super(l,w,h);
        this.weight = weight;

        // Used to access the weight variable from the parent classs
        // super.weight;
    }


    // The following this is exactly same as (Box box5 = new BoxWeight(2,3,4,9))
    BoxWeight(BoxWeight other){
        /*
        You can either do 
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;

        OR

        super(other);
        
        They both will work same and their working is exactly similar to Box refV = new BoxWeight(2,3,4,9);
        */

        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
        this.weight = other.weight;
    }
}