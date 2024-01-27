package example.genericArrayList;

import java.util.Arrays;

public class CustomGenArrayList<T> {
    private Object[] data;
    private int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomGenArrayList(){
        this.data = new Object[DEFAULT_SIZE];  // look explanation 1 below
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size] = num;
        size++;
    }

    public T remove(){
        T removed = (T)(data[--size]);
        return removed;
    }

    public T get(int index){
        if(index >= size){
            System.out.println("Invalid Index");
            return null;
        }
        return (T)(data[index]);
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    private boolean isFull(){
        return size == data.length;
    } 
    private void resize(){
        Object[] temp = new Object[data.length * 2];
        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    @Override
    public String toString() {
        return "Custom ArrayList: " + Arrays.toString(data);
    }
}


/*
______________________________NOTES______________________________

__________________________Explanation 1__________________________
---> The error is because we know that at runtime only the bytecode gets executed... And bytecode is generated at compile time... Now (this.data = new T[DEFAULT_SIZE];) specifies to create an instance of generic type... But as at compile time the "T" does not get resolved so no instance of it can be created at runtime....

_______________________Solution_________________________
---> We know that every class inherit Object class... So we can use Object to specify those types...

________________________Cannot create static fields of type parameters_____________
---> You cannot do something like:
pubic static T var;

this is because static fields has to get resolved at compile time but generic T parameter gets replaced with the original type at runtime so this cannot be done...

________________________Type Erasure______________________
---> At runtime, the actual type parameter T is erased and replaced with its upper bound or the first bound if none is specified. This process is known as type erasure
*/