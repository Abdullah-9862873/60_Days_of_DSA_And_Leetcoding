public class InnerClasses{
    static class In1{
        int age;
        In1(int age){
            this.age = age;
        }

        void printAge(){
            System.out.println("The age is: " + this.age);
        }
    }

    public static void main(String[] args) {
        In1 obj = new In1(20);
        obj.printAge();
    }
}

/*
______________________________________________________________
----> When you make a class inside another class then the inner class is now basically depending on the outer class... This means, to create an instance of inner class, an instance of outer class needs to be created... But if you make the inner class to be static then that means that the inner class is not depending on the the instance of the outer class so you can make the instance of inner class without having to create outerclass instance...
For Example:
public class InnerClasses{
    static class In1{
        int age;
        In1(int age){
            this.age = age;
        }
    }
    
    public static void main(String[] args) {
        In1 obj = new In1(20);
        System.out.println(obj.age); 
    }
}

----> Now if you make an outer class static, then this makes no sense as static shows independency, so tell me from who you want your class to be independent... This makes no sense... So this is why the outer class cannot be static because they are not actually depending on another class...
For example

static class Out{
    
}

This gives an error
______________________________________________________________
What if you make both the outer and inner classes non-static??

---> You have to do the following to make it work then... 
1) Creation of instance of outer class...
2) Creation of instance of inner class...
3) Accessing the printAge() function using innerClass instance...

public class InnerClasses {
    class In1 {
        int age;
        
        In1(int age) {
            this.age = age;
        }
        void printAge(){
            System.out.println("The age is: " + this.age);
        }
    }

    public static void main(String[] args) {
        InnerClasses ob = new InnerClasses();
        InnerClasses.In1 obj = ob.new In1(20);
        obj.printAge();
    }
}
______________________________________________________________


*/