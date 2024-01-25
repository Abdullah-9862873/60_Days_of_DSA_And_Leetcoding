package example.customArrayList;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    private int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size] = num;
        size++;
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        if(index >= size){
            System.out.println("Invalid Index");
            return -1;
        }
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
        data[index] = value;
    }

    private boolean isFull(){
        return size == data.length;
    } 
    private void resize(){
        int[] temp = new int[data.length * 2];
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
___________________________NOTES___________________________
_________________________PROBLEM PRESENT HERE______________________________
----> Now the problem here is that in simple arraylist we have the choice to make the arraylist of String type or Integer type or any other datatype... But we dont have the same choice here... In our customArrayList we have to make an arraylist of integer type...
CustomArrayList list = new CustomArrayList();       // Creates integer type list

ArrayList<Integer> list = new ArrayList();          // Integer type list
ArrayList<String> list = new ArrayList();           // String type list


So these <Integer> <String> are generics that allow us to reuse the same code of ArrayList with different classes such as here "Integer" class and "String" class... Generics accepts only "classes" as parameter...
*/
