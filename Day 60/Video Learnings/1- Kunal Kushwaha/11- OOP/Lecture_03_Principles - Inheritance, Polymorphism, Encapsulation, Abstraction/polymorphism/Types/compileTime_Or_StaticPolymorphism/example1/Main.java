package Types.compileTime_Or_StaticPolymorphism.example1;

public class Main {
    public static void main(String[] args) {
        // Box box1 = new Box();
        // System.out.println(box1.l + " " + box1.w + " " + box1.h);

        // BoxWeight box2 = new BoxWeight(2);
        // System.out.println(box2.weight);

        // BoxWeight box3 = new BoxWeight(2,3,4,9);
        // System.out.println(box3.l + " " + box3.w + " " + box3.h + " " + box3.weight);

        // Box box5 = new BoxWeight(2,3,4,9);
        // Following is not alllowed
        // box5.weight;

        BoxWeight box2 = new BoxWeight(2,3,4,8);
        BoxWeight box = new BoxWeight(box2);
        System.out.println(box.l + " " + box.w + " " + box.h + " " + box.weight);

        
    }
}


/*
____________________To Run this________________________
---> Use same methods described in inheritance example...
*/