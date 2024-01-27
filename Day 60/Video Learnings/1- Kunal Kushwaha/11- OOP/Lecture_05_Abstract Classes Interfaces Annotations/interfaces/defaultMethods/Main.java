package defaultMethods;

public class Main implements A, B{
    // @Override
    // public void fun() {
        
    // }

    @Override
    public void greet() {
        
    }
}

/*
______________________________NOTES______________________________
--->  Since "Main" is implemneting both "A" and "B" so it has to override all the abstract methods present inside A and B... But in java8, there is something called default where you can provide default implementation of abstract methods in the interfaces while declaring them... Example, look at A interface 

---> By doing this, you dont have to override the fun() method at every class that implements "A"... This was the idea behind doing this... 

__________________Problem created using this_____________________
----> But this is a cause of creation of a problem... And the problem is that if "A" has a default method fun() and "B" has a default method fun() then there will be a collapse in the Main which is implemnting them both... This will give us the following error
"Duplicate default methods named fun with the parameters () and () are inherited from the types B and A"

Isn't this the same problem that we were facing in the multiple inheritance in simple classes problem... But again the behind idea I've told earlier...
*/
