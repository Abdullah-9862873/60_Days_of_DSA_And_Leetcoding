package example;

public class BoxWeight extends Box{
    double weight;

    // First contructor
    BoxWeight(double weight){
        this.weight = weight;
    }

    // Second contructor
    BoxWeight(double l, double w, double h, double weight){
        super(l,w,h);
        this.weight = weight;

        // Used to access the weight variable from the parent classs
        // super.weight;
    }


    // The following this is exactly same as (Box box5 = new BoxWeight(2,3,4,9))
    BoxWeight(BoxWeight other){
        /*
        You can either do 
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;

        OR

        super(other);
        
        They both will work same and their working is exactly similar to Box refV = new BoxWeight(2,3,4,9);
        */

        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
        this.weight = other.weight;
    }
}


/*
________________________________NOTES________________________________

________________What is super keyword?________________
----> Now here "BoxWeight" is derived class and "Box" is a base class... By default the constructors are public so no need to write public before the constructors... Here, we are declaring that when a constructor of "BoxWeight" is called with only one argument then first constructor will get called but if we want that we pass 4 values in the constructor of "BoxWeight" and it passes 3 values to the parent's constructor i-e "Box" constructor and the fourth value which is its own property is set normally... For this we can use super... super gets replaced with "Box" just like the "this" gets replaced with reference variable... so super(l,w,h) means Box(l,w,h) and it will call that constructor and sets the values....
----> Super keyword is used to call the constructor of parent class... 
----> Example: We have a class A as parent and B as child... And class C as child of class B... Now super keyword used in C will refer to the constructors being used in class B and the super keyword used in class B will refer to the constructors being used in class A... And the super keyword used in class A will refer to the Object class... This is because in java Every class is being inherited from Object class... This is inbuilt stuff...

_________________UseCase of super keyword_________________
----> One usecase is to access the constructors of parent class...
----> Another usecase is to use it like this keyword.... Example: lets say "BoxWeight" has a variable "weight" and "Box" has a variable "weight" too... Now if you are in BoxWeight and you are writing something like "this.weight" it means that first find "weight" inside BoxWeight and if you can't find there then find in its parent and if you find there then take it... But what if you specifically want to access the "weight" from parent class... In that case, you can write super.weight...

______________Difference between argument and parameter______________
The values that are declared within a function when the function is called are known as an argument. The variables that are defined when the function is declared are known as parameters.

____________________You cannot do the following______________________
---> You cannot initialise super stuff afterwards like the following
BoxWeight(double l, double w, double h, double weight){
    this.weight = weight;
    super(l,w,h);
}

This is because the parent does not care about what child class contains so it will say I'll initialise myself first but the child do care about what parent class contains so child class properties are initialised later...

______________What does the following mean?__________________
    BoxWeight(BoxWeight other){
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
        this.weight = other.weight;
    }

----> It means exactly same as:
Box box5 = new BoxWeight(2,3,4,9);

----> Look We are passing an object as parameter inside the constructor then it will look at if "other" can have access to all the stuff being represented inside the constructor i-e (l,w,h,weight)... And the answer to that is Yes... So it will not throw an error...

----> On the other hand you cannot do the following:

    You cannot do the following because "this" represents ref variable of "Box" which has no access to what child classes are having... This is same as 
    BoxWeight other = new Box(2,3,4,9);
    
    Box(BoxWeight other){
      this.weight = other.weight;
    }
*/
