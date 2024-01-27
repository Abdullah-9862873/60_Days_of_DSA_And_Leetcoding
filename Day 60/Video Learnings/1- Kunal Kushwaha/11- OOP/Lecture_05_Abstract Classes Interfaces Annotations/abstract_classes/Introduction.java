



/*
__________________________________NOTES__________________________________

______________________________What are abstract classes?______________________________
----> Consider a parent class which has a method declaration and the name of the method is "career" that accepts name of the career as argument... Now Consider its two subclasses "A" and "B"... Now "A" has its own defination of the career... And " B" can have its own defination of the career... It means since the parent class has no body of the method "career" so it is now relied on the children to have their own defination for the method "career"...

---> It means that "career" is a method in the parent class that does not have any implementation or body, its just the declaration and the subclasses "A" and "B" defines the body of "career" as they want...

---> Example:

abstract class Bike{  
  abstract void run();   // Method declared but body not defined
}  

class Honda extends Bike{  
    void run(){
        System.out.println("running safely");
    }  
}

public static void main(String args[]){  
 Bike obj = new Honda();  
 obj.run();  
}  

______________________________Important rules______________________________
----> Every child class must override all the abstract methods present in the parent class...
----> Any class that contains one or more abstract methods must be declared as abstract...

---> Abstract classes are more concerned about what the class is doing rather how its doing...
*/