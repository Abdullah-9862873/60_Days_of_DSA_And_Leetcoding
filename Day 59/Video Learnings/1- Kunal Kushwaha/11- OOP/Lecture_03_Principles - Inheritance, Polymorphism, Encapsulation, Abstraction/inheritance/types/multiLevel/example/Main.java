package types.multiLevel.example;

public class Main {
    public static void main(String[] args) {
        BoxPrice box = new BoxPrice(2,3,4,5,9);
        BoxPrice box2 = new BoxPrice(box);
        System.out.println(box2.l + " " + box2.w + " " + box2.h + " " + box2.weight + " " + box2.price);

        BoxPrice obj = new BoxPrice(2, 20, 2000);
        System.out.println(obj.l + " " + obj.w + " " + obj.h + " " + obj.price + " " + obj.weight);
    }
}


/*
________________To run___________________
----> Go to the directory inheritance\types\multiLevel\example
----> Enter the command, "javac Main.java Box.java BoxPrice.java BoxWeight.java"
----> Go outside the inheritance directory by doing cd.. 
----> Enter the command, "java -cp . inheritance.types.multiLevel.example.Main"

_____________Hierarchy generated here is______________
                            Box
                            ↓
                            BoxWeight
                            ↓
                            BoxPrice
*/


