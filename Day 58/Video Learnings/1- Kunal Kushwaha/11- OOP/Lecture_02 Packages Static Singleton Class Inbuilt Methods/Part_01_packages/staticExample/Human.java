package staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population;

    static void message(){
        System.out.println("This is a message from Human Class");

        // Following will throw error... See in notes
        // System.out.println(this.salary);
    }

    public Human(int age, String name, int salary, boolean married){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population += 1;
        Human.message();
    }
}


/*
______________________NOTES______________________

______________________Population being static______________________
----> Lets say we have a variable that does not depend on individual objects, for example population does not depend on individuals rather for every human being the overall population will be 7 Billion only...
----> Now I want that when a new human being is created then population gets incremented and thats why we have mentioned it in the constructor
----> In this construction Human.population is used rather than this.population and the reason is the independency of the variable on objects... So static variables are the variables that are independent on objects... So the convention is not to use "this" rather use the class name, though both can perform same functions...

__________You can't use "this" within a static context___________
----> Because "this" gets replaced with object's reference variable and static is something that is not dependent on the creation of objects... So anything that is somewhere connected to or dependent to object creation can never be inside static context...


*/