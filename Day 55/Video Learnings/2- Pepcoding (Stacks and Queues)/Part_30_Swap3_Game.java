public class Part_30_Swap3_Game {
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

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";

        p1.sayHi();
        p2.sayHi();
        swap(p1,p2);
        p1.sayHi();
        p2.sayHi();
    }
    public static void swap(Person p1, Person p2){
        p1 = new Person();
        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;

        p2 = new Person();
        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;
    }
}

/*
----> Here make stack make heap memory allocate the resources and analyze yourself how the changes are happening...
 */