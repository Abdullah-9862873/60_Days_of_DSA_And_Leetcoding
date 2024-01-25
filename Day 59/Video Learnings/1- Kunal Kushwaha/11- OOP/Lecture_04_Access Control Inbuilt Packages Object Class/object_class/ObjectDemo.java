package object_class;

public class ObjectDemo {
    private int num;
    private float gpa;
    
    public ObjectDemo(int num, float gpa){
        this.num = num;
        this.gpa = gpa;
    }

    // Object // You can control click on it to look at Java's object class... it has the following stuff

    // Hashcode means a unique representation of an object via number... hashcode is not an address rather it is a random integer value...
    @Override
    public int hashCode() {
        // return super.hashCode();
        return num;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // return super.equals(obj);    // without modification
        return this.num == ((ObjectDemo)obj).num;   // done some typecasting
    }


    // Covered previously as it is used when an object is printed lets say and in the terminal a hashcode value gets generated but if we want it to print something else lets say a data member instead of hashcode then we can override toString as "println" use toString internally
    @Override
    public String toString() {
        return super.toString();
    }

    // Covered previously as it is used when a reference variable points to an obj in heap memory and lets say then we make it to point to another object then the previous objects gets freed and is grabbed by garbage collector... And with finalize we can specify to garbage collector that when you destroy this object then do the following thing lets say print "Object is destroyed" and stuff like that....
    // @Override
    // protected void finalize() throws Throwable {
    //     super.finalize();
    // }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(12,58.9f);
        ObjectDemo obj2 = new ObjectDemo(12, 78.2f);

        // System.out.println(obj.hashCode());    // modified the hashcode so now it will print the num

        if(obj == obj2){
            System.out.println("obj is equal to obj2");
        }

        if(obj.equals(obj2)){
            System.out.println("obj is equal to obj2");
        }
        System.out.println(obj.equals(obj2));

        System.out.println(obj instanceof ObjectDemo); // To know if an instance belongs to a class 

        System.out.println(obj.getClass()); // To inquire about the class of any object

        // some more methods can be used like the following:
        System.out.println(obj.getClass().getName());
    }
}


/*
_______________________________How to Run?_______________________________
---> To run this use the same steps as in the previous lectures...

______________________Equals___________________________
----> The difference between (obj == obj2) and (obj.equals(obj2)) is that... == is used to to compare if both reference variables are pointing to the same object... But .equals is used to compare the content inside...

---> Initially without overriding the .equals it will not print anything but if we do the motification like the following:

*/