package interfaces.example2;

public class Car {
    private Engine engine;
    private Media media = new CDPlayer();

    Car(){
        this.engine = new PowerEngine();
    }

    Car(Engine engine){
        this.engine = engine;
    }

    public void start(){
        engine.start();
    }

    public void stop(){
        engine.stop();
    }

    public void startMusic(){
        media.start();
    }

    public void stopMusic(){
        media.stop();
    }
    
    public void upgradeEngine(Engine engine){
        this.engine = engine;
    }
}
