package polymorphism.Types.compileTime_Or_StaticPolymorphism.example2;

public class Main {
    public static void main(String[] args) {
        Numbers num = new Numbers();
        int first = num.sum(2,3);
        int second = num.sum(2,3,4);

        System.out.println(first);
        System.out.println(second);
    }
}


/*
______________________Running this code is same as previous running rules_________________
*/