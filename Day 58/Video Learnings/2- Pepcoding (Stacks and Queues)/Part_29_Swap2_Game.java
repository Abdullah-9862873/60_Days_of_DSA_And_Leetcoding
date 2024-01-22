public class Part_29_Swap2_Game {
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
        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;

        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;
    }
}

/*
---> Since when we call a function then copies of the references are made... These copies are still pointing to the original instance in the heap memory... So when something is accessed from these references then we can access and mutate that data... When the function gets over then only references are destroyed and the changes made in the actual instance in the heap memory using those copies will not get changed... This is why swapping is happening in this case
 */
