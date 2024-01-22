public class Part_28_Swap_Game_1 {
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
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
}


/*
----> Here the swap will not get happen... This is because only the copies of the references are getting swapped and they will be destroyed when the function is ended without changing the actual references of the instances...
 */