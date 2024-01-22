public class Part_27_OOPs_Classes_and_Objects{
    public static class Person{
        int age;
        String name;

        void sayHi(){
            System.out.println(name + "[" + age + "]" + " says hi");
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";
        p1.sayHi();

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";
        p2.sayHi();

        Person p3 = p1;
        p3.age = 30;
        p3.sayHi();
        p1.sayHi();


    }
}

/*
-----------Notes-----------
----> Now there are two memories that are used stack memory and heap memory... When the new keyword gets triggered then a heap memory is allocated... In the heap memory there is an instance or object located that contains age and name and sayHi function.... And in the stack memory there are reference p1 and p2 of the two instances in the heap memory...

----> In this example p3 is a reference that is pointing towards p1 and when p3.age is set then the age of the address of p1 will get changed... 

 */