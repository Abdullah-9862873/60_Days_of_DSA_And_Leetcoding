public class StaticBlock{
    static int a = 4;
    static int b;

    // Static Block
    static{
        System.out.println("I am inside static block");
        b = a*4;
    }

    public static void main(String[] args) {
        StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
        
        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
        
        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}

/*
_______________________________________________________
What is happening Here? and what is Static Block?

---> Static block is a part of code that runs once only when the first object is been created...

---> In this code, when obj1 is created... It will do three things

1) Declaration and Initialisation of "a"
2) Declaration of "b"
3) Running the Static Block

---> Then the "b" is accessed and being added with 3... It will mutate b...

---> When obj2 is created, then it will not run the static Block again... Because static block is only run once when the obj is first created of the class... All the static blocks are run only once...
*/