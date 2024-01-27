package types.multiLevel.example;

public class BoxPrice extends BoxWeight{
    double price;

    BoxPrice(){
        super();    // Call the parent's constructor
        this.price = -1;
    }

    BoxPrice(double price){
        super();
        this.price = price;
    }

    BoxPrice(BoxPrice other){
        super(other);
        this.price = other.price;
    }

    BoxPrice(double l, double w, double h, double weight, double price){
        super(l,w,h,weight);
        this.price = price;
    }

    BoxPrice(double side, double weight, double price){
        super(side, weight);
        this.price = price;
    }
}

