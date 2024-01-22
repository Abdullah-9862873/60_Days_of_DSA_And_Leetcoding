package polymorphism.Types.runtime_or_dynamic_polymorphism;

public class Runtime_Or_Dynamic_Polymorphism {
    
}


/*
_____________________________NOTES_____________________________

_________________________How its achieved?_________________________
----> It is acheived via Method Overriding...

_________________________What is Method Overriding?_________________________
----> Method overriding is when the parent class and the child class both have a method with same name and same number of arguments or types of arguments or ordering of arguments... 
----> When this happens then the preference will be given to the method present in child class only if the object is of child class... Example shown in example section...

_____________________How overriding works? and what is Upcasting?________________
----> Lets say from the example we have something like:
Shapes obj = new Circle();
obj.area();

Now here, obj is a reference variable of type "Shapes" and it is pointing to an object of type "Circle"... Now "obj" can only access what can be accessed using objects of "Shapes" type... But "area" from which class will be run?? The area() of Circle will get run because when a ref variable of parent class is pointing to an object of its child and an overriding method is run then the method of child class is run everytime... This concept is known as UpCasting... And this is how overriding works...

______________________How Java determines this?______________________
---> This is done via method called "Dynamic Method Dispatch"... 
---> This method helps Java to resolve which method to run at run time... And this is why this method is known as Dynamic polymorphism...



*/
