package example1;

public class Daughter extends Parent{
    @Override
    void career() {
        System.out.println("I want to be a coder");
    }

    @Override
    void partner() {
        System.out.println("I love Iron Man");
    }

    Daughter(int age){
        super(age);
    }
}
