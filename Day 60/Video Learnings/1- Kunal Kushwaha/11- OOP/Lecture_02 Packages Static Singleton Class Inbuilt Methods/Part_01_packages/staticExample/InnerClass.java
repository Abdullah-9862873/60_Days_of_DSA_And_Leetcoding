package staticExample;

class Test {
    static String name;

    public Test(String name) {
        Test.name = name;
    }
}
public class InnerClass {

    public static void main(String[] args) {
        // InnerClass obj = new InnerClass();
        // InnerClass.Test obj2 = obj.new Test("Abdullah");
        // System.out.println(obj2.name);

        Test obj = new Test("Abdullah");
        Test obj2 = new Test("Ahmed");
        
        System.out.println(Test.name);
    }
}





/*
_________________________NOTES________________________

----> When the "Test" class is inside the "InnerClass" and lets say the "Test" class is not static... Then you cannot do something like the following inside the "main" function:
Test obj1 = new Test("Abdullah");
Test obj2 = new Test("Ahmed");

This is because, you are creating an object of class "Test" and that class "Test" is non-static which means that it depends on its parent class i-e "InnerClass"... So an object of "InnerClass" needs to be created in order to access the "Test" class... You can do the following to run it:
InnerClass obj = new InnerClass();
InnerClass.Test obj2 = obj.new Test("Abdullah");
System.out.println(obj2.name);

----> But, if you make the "Test" class static, then the "Test" class does not depend on the outer class... And you can do the following:
Test obj = new Test("Abdullah");
System.out.println(obj.name);

____________Outer Classes can never be static___________________
----> But, if you move the "Test" class outside the "InnerClass" then as it will not have any of the outer class... 
So look, static class means, that it does not depend on the creation of object of its outer class... Now that if the class is moved outside and it does not have any other outer class of itself... Then does it make sense to make it static... No... Thats why the outer classes can never be static... And you can run it like the same:
Test obj = new Test("Abdullah");
System.out.println(obj.name);


----> Now if I make the inner variable of it as static like:
class Test {
    static String name;

    public Test(String name) {
        this.name = name;
    }
}
And note that the location of the "Test" class is outside of "InnerClass"
Then if I do something like
        Test obj = new Test("Abdullah");
        Test obj2 = new Test("Ahmed");
        
        System.out.println(Test.name);

Then it will print "Ahmed"... This is because the "name" variable is now independent of the reference variables of objects...


_________Static classes resolution____________
----> Since the objects are created at runtime and the static classes are independent of the creation of objects of upperClass, hence the static classes are resolved during compile time... Early binding is being done here

*/
