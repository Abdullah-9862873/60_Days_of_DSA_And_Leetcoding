package example.package2;

import example.package1.A;

public class B extends A{
    public B(int num, String name, int price) {
        super(num, name, price);
    }

    public static void main(String[] args) {
        A obj = new A(12, "Abdullah",5500);
        // System.out.println(obj.num); // Can't access if num is default access controlled

        // System.out.println(obj.price);  // Not allowed see the reason below
        System.out.println(obj.getNum());
        B obj2 = new B(12, "Abdullah", 5500);
        System.out.println(obj2.price); // Allowed, see the reason below
    }
}



/*
______________________NOTES______________________
___________________________why num cannot be accessed?___________________________
----> You cannot access "obj.num" here if the "num" is having default access control in "A" class of package1...
----> But you can access it if the "num" is having public access control in class "A" of package1...

________________________why following is not working?______________________
System.out.println(obj.price);

----> We know that "price" is protected... Which means it can be accessed with different package when inheritance is involved... And we know that B is inherited from A and is present in different package so why it is not working...
----> Its not working because, the object "obj" is of type "A" which is a superclass... And we know that access is allowed only to different package when inheritance is involved which means B is inherited from A so if the object is of type "B" then only you can have access to "price"...
----> If "obj" is of type "A" and "obj.price" is allowed then no difference remains between protected and public because with importing the class "A" simply, if you can access all the data members then no difference remains between protected and public...

_______________________So when exactly can a protected be accessed?______________
----> Protected data member can be accessed from a "B" that is being inherited from the class "A"...
----> It can also be accessed in any class that is inheriting from class "B"... See the "subClass" in this package...

*/


