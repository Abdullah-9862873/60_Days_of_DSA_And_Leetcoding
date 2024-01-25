package example;

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
---> Open terminal in the directory \inheritance\example and type the command "javac Box.java Main.java BoxWeight.java"
---> After this compilation move to the main directory which is the main folder outside the inheritance by doing "cd.." two times
---> After this type the command "java -cp . inheritance.example.Main"


_____________________What does the following mean?_____________________
----> Box box5 = new BoxWeight(2,3,4,9);

----> It means, reference variable "box5" is of type "Box" and the object is of type "BoxWeight"
----> It is the type of reference variable that determines which properties and methods and variables you can access... For example, here the box5 is a reference variable of type "Box" so you cannot do something like "box5.weight" because weight is not present in the "Box"...

----> "box5" is a reference variable of type "Box" present in the stack memory and it is pointing to the object of type "BoxWeight" present in heap memory...

----> BoxWeight is a child of Box and an object of BoxWeight has the access to all the properties and functions of Box... Since this object has all the accesses that's why it is working fine...


__________________Why will the following give error?________________________
BoxWeight box6 = new Box(2,3,5);

----> The reference variable "box6" is of type "BoxWeight" i-e child class... And it is pointing to an object of type "Box" which is parent class... 
Since box6 is of type BoxWeight so you can do something like box6.weight because we know that a reference variable can have access to the properties and methods of its own type...
But since it is pointing to an object of parent class "Box" which has no idea about "weight" then there will be a mismatch that "box6" has the idea about "weight" but the object it is pointing to has no idea about it... So thats why it will give error...

----> In short, a parent can point towards child but a child cannot point towards parent...
*/