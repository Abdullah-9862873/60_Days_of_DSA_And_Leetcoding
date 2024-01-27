package staticExample;

public class StaticBlock {
    static int a = 4;
    static int b;

    static {
        System.out.println("I am static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        // Since the variables are static so no need to create an object... You can directly access via class name... Here I am creating object just to demonstrate the working of static block
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
        
        StaticBlock.b += 3;
        
        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}


/*
______________________NOTES______________________

___________What is Static Block?___________
----> Static block is a block of code that is run exactly once when the class is first loaded...
----> In this example, when the object is created of class "StaticBlock" first, then static block is run and the values are being set of the static variables... But then if I am creating another object of "StaticBlock" then that static block is not running again...

___________Use of Static Block___________
----> If we have any static variables inside the class and we want to assign them values in dynamically then static block is used... Or it can also be used to display a message once when the class is used...


*/