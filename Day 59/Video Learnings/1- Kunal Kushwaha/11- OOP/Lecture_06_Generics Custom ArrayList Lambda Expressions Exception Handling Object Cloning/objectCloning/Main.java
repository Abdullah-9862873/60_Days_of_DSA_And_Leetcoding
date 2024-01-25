package objectCloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human abdullah = new Human("Abdullah", 20);
        // Human ahmed = new Human(abdullah);

        Human obj = (Human)abdullah.clone();
        System.out.println(obj.age);
        System.out.println(obj.name);

        System.out.println("Abdullah's arr is: " + Arrays.toString(abdullah.arr));
        System.out.println("obj's arr is: " + Arrays.toString(obj.arr));

        obj.arr[1] = 200;

        System.out.println("Abdullah's arr is: " + Arrays.toString(abdullah.arr));
        System.out.println("obj's arr is: " + Arrays.toString(obj.arr));

        System.out.println();
        obj.name = "Changed Name";
        System.out.println("Abdullah's name is: " + abdullah.name);
        System.out.println("Obj's name is: " + obj.name);
    }
}

/*
_______________________NOTES_______________________
______________________Problem in normal cloning
---> You can use the following method to create a copy of an object in another instance.... But this is not efficient as dynamic memory allocations are involved using new keyword... 
        Human abdullah = new Human("Abdullah", 20);
        Human ahmed = new Human(abdullah);
______________________Solution________________________
---> Rather we can use Cloneable interface to clone an object...
---> so the idea is that the object whose clone you want to create gets implemented with Clonable...
---> In Object class there is a method called "clone" that is used with Clonable interface to clone an object...


_______________________Why exception is mentioned?___________________
---> In java if you use a method defined in an object and that object whose method you are using is throwing an exception then you have to throw an exception too where you are using it... For Example clone method inside Object is throwing an exception so when we are using it inside the Human class then we have to throw an exception there too....
*/