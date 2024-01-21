package example;

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

    // You cannot do the following because "this" represents ref variable of "Box" which has no access to what child classes are having... This is same as 
    // BoxWeight other = new Box(2,3,4,9);

    // Box(BoxWeight other){
    //     this.weight = other.weight;
    // }

    public void information(){
        System.out.println("I am running");
    }
}



/*
_________________________NOTES_________________________
----> If we make the "l" private then it can only be accessed in "Box" class only... Then you cannot do something like "this.l" in "BoxWeight" class in any of the constructors...


*/