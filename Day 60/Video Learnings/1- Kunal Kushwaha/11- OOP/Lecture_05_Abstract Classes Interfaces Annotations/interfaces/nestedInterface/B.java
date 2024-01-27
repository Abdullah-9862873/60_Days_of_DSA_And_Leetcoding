package nestedInterface;

public class B implements A.NestedInterface{

    @Override
    public boolean isOdd(int num) {
        return num % 2 != 0;
    }
    
}
