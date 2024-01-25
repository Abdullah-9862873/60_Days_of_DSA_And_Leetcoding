package types.multiple;

public class Multiple {
    public static void main(String[] args) {
        
    }
}


/*
_________________________NOTES_________________________
----> Multiple Inheritance is when a class is extending more than one classes...
Mutiple PAPA's JK... 


                        A               B
                        ↓               ↓
                        → → →   C   ← ← ←

____________________Why java does not support Multiple Inheritance____________________
----> It is because lets say class "A" has a variable n=5 and class "B" has a variable n=10... Now when we do the following 
C obj = new C();
obj.n = ??       we dont know if its gonna take the value of n from class "A" or "B"... 

That's why multiple inheritance is not allowed in Java...


____________________But how can we implement Multiple Inheritance____________________
----> If we want to use multiple inheritance in java then we can implement it by using "Interfaces"... 
*/
