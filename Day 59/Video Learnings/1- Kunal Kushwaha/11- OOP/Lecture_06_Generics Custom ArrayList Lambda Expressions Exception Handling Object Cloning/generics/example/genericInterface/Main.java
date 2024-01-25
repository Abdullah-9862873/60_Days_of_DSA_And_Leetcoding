package example.genericInterface;

public class Main implements A<String>{
    @Override
    public void display(String statement) {
        System.out.println("I am displaying");
    }
}
