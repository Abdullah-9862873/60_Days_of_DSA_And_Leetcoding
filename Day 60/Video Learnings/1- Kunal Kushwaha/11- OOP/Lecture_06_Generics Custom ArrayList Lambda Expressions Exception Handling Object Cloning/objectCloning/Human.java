package objectCloning;

public class Human implements Cloneable{
    int age;
    String name;
    int[] arr;

    public Human(String name, int age){
        this.name = name;
        this.age = age;
        arr = new int[]{3,4,5,6,1};
    }

    public Human(Human other){
        this.age = other.age;
        this.name = other.name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        // This is creating shallow copy
        return super.clone();
    }

    // @Override
    // public Object clone() throws CloneNotSupportedException{
    //     // This is creating deep copy
    //     Human twin = (Human)super.clone();


    //     twin.name = this.name;
    //     twin.arr = new int[this.arr.length];
    //     for(int i=0; i<twin.arr.length; i++){
    //         twin.arr[i] = this.arr[i];
    //     }
    //     return twin;
    // }
}

/*
____________________________WHAT IS SHALLOW COPY?___________________________
---> Shallow copy means that all the primitives gets copied like integer and float etc... But the non-primitives are not copied they are pointed with other referece... 
---> For Example, there is obj1 and obj2... obj1 has int age, String name and int[] arr... And obj1 is cloned to obj2... Now new variables for primitives like "age" gets generated for obj2 and value is copied to it... But new variables are created for "name" and "arr" and they just point to the name and arr of obj1... 
Now if something changes in name and arr from obj2 will reflect on original...

____________________________WHAT IS DEEP COPY?___________________________
---> Deep copy on the other hand creates copies of primitives as well as non-primitives so any change in obj2 will reflect only in obj2 and not in obj1.

__________________________Strings being non-primitive why are they not reflecting change___
---> Arrays are mutable objects in Java, meaning you can modify their contents directly. When you clone an array using clone(), you get a new reference to the same array. So, modifying the array through one reference will indeed affect the other.

---> On the other hand, String objects are immutable in Java. When you modify a String, you are not actually modifying the existing String object but creating a new one. In your case, when you set obj.name = "Changed Name";, you are creating a new String object with the value "Changed Name" and associating it with the name field of the obj instance. This operation does not modify the original String object associated with abdullah.name
*/
