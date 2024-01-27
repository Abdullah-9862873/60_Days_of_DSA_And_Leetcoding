package example;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();

        Media med = new Car();
        med.stop();

        // We can also do something like Engine car = new Car(); ... like we did previously
        // Here the media is making engine to stop, this is the problem
    }
}


