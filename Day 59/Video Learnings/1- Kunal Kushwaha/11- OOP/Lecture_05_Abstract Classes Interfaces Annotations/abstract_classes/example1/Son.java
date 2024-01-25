package example1;

public class Son extends Parent{
    @Override
    void career() {
        System.out.println("I want to be a doctor");
    }

    @Override
    void partner() {
        System.out.println("I love Pepper potts");
    }

    Son(int age){
        super(age);
    }
}
