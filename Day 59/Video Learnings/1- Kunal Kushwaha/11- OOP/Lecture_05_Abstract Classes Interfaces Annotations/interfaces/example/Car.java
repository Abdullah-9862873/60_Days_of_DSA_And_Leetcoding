package interfaces.example;

public class Car implements Engine, Brake, Media{
    @Override
    public void start() {
        System.out.println("I am starting Engine like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("I am stoping Engine like a normal car");
    }

    @Override
    public void acc() {
        System.out.println("I am accelerating like a normal car");
    }

    @Override
    public void brake() {
        System.out.println("I am braking like a normal car");
    }
}


/*
__________________________NOTES__________________________
________________VISUALISATION OF DIFFERENCE BW INTERFACES AND ABSTRACT CLASSES______
----> Here, class "Car" is being inherited by more than one classes i-e its showing multiple inheritance phenomenon... But abstract classes or the normal classes in java cannot do so...


_________________A Problem here_____________________
----> Lets say that the car is implementing Engine, Media and Brakes... Now "Media" has start and stop methods and "Engine" has start and stop methods... Which methods are going to be accessed by it... Or lets say in Main if we do the following:

Media media = new Media();
media.start();

Its gonna print "I am starting Engine like a normal car"

because the start and stop methods in "Car" are like:
@Override
    public void start() {
        System.out.println("I am starting Engine like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("I am stoping Engine like a normal car");
    }


___________________Solution of this problem__________________
---> Solution is done in example2


*/