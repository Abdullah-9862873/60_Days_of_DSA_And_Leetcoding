package example;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        // box.l;  // This is not allowed, as 'l' is private
        double ans = box.getL();
        System.out.println(ans);
    }
}
