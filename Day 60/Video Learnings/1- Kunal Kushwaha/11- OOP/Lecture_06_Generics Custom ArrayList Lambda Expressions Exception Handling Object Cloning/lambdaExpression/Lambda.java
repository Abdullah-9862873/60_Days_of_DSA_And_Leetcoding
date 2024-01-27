package lambdaExpression;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<5; i++){
            arr.add(i + 1);
        }

        arr.forEach((item) -> System.out.println(item * 2));
        Consumer<Integer> fun = (item) -> System.out.println(item * 2);
        arr.forEach(fun);

        Operation<Integer> add = (a,b) -> a + b;
        Operation<Integer> prod = (a,b) -> a * b;
        Operation<Float> div = (a,b) -> a / b;
        Operation<Integer> sub = (a,b) -> a - b;

        System.out.println(add.operation(2,3));
    }
}

/*
_______________________NOTES_______________________
---> Lambda expression is the way to convert a function which has a single line body to one line expression...

---> Lambda expression can be assigned to variables that are of type interface... For example:

        Consumer<Integer> fun = (item) -> System.out.println(item * 2);
        arr.forEach(fun);

The lambda expression is assigned to variable "fun" which is of type "Consumer" interface...

Similarly you can create your own interface and do it for example look at the interface Operation...
*/
