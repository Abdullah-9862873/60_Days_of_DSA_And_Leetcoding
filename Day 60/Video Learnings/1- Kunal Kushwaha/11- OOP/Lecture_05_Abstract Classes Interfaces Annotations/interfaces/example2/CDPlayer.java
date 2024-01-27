package example2;

public class CDPlayer implements Media{
    @Override
    public void start() {
        System.out.println("Media Start");
    }

    @Override
    public void stop() {
        System.out.println("Media Stop");
    }
}
