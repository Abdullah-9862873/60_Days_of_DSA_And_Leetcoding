package defaultMethods;

public interface A {
    default void fun(){
        System.out.println("I am a default fun of A");
    }

    static void greeting(){
        System.out.println("Hey I am static ");
    }
}

/*
---> Static interface methods should always have a body... since static methods cannot be overriden so they must have a body...
*/