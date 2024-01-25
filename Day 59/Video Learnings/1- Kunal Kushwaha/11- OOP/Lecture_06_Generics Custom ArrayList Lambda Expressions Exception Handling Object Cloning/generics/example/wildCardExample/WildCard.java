/*
_______________________________INTRODUCTION__________________________
---> Wildcard is a special type argument that controls the type safety...

---> Lets say you have the custom generic arraylist... And we know that arraylist allows us to make a list of Integer type of string type or other types that we can directly pass as a parameter using generics... 

__________________________WHAT IS NUMBER CLASS_______________________
---> A Number class in java has all the classes relaated to numbers like Integer Float and all... 

_________________________USING WILDCARD FOR TYPESAFETY_______________
---> Lets say we want our CustomGenArrayList to accept only the generics that are related to Number class... i-e to only accept classes such as Integer, Float etc and not like String etc... We can achieve it via WildCard 
We just have to do the following

public class CustomGenArrayList<T? extends Number>

Now T will only represent the classes from Number class...

---> Example2, lets say we have the following function

public void getList(List<Number> list){

}

Here you can only pass "Number" class but if we want to pass the subclasses of Number type as parameter to this function also then we can use wildcard as:

public void getList(List<? extends Number> list){

}
*/