package extendDemo;

public class Main implements B{
    @Override
    public void greet() {
        
    }

    @Override
    public void fun() {
        
    }
}


/*
---> So the idea is that if an interface is extending another interface then you can imagine that all the methods from the other interface are now a part of the interface that is extending the other... 
For example, here "B" interface is extending another interface "A"... So you can imagine "B" to have fun() method inside of it too like:
void greet();
void fun();

And since the "Main" is implementing "B" so it has to override all the methods inside interface "B"
*/