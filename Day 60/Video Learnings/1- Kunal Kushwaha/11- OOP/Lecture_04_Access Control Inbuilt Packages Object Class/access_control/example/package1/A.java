package example.package1;

public class A{
    private int num;   // default acccess modifier
    // public int num;     // public access modifier
    // private int num;     // private access modifier

    protected int price;

    String name;
    int[] arr;

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public A(int num, String name, int price){
        this.num = num;
        this.name = name;
        this.price = price;
        this.arr = new int[34];
    }
}


/*
_____________________________NOTES_____________________________
There are total five places of access:
1- Within Same class
2- Within same package
3- Inheritance involved, same package
4- Inheritance involved, different package
5- No Inheritance involved, different package

_____________________Public access control_____________________
----> All five places can be accessed via public access control over a data member...

_____________________Protected access control_____________________
----> 1, 2, 3, 4 can be accessed via protected access control over a data member...

_____________________Default access control_____________________
----> 1,2,3 can be accessed via default access control over a data member...

_____________________Private access control_____________________
----> Only 1 can be accessed via private access control over a data member...
----> Getters and Setters methods are used to access the data...
*/