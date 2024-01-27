package nestedInterface;

public class A {
    protected interface NestedInterface{
        boolean isOdd(int num); 
    }
}

/*
---> Here, a nested interface is present, the only difference is that the nested interfaces can be public, private or protected but the top level interface has to be declared as public or default... 
 */