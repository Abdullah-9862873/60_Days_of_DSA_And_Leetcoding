package pkg.a;

import pkg.b.Meeting;

public class Main {
    public static void main(String[] args) {
        /*
        The following you can run if you have made the printMsg() function like the following in the Meeting file
        public void printMsg() {
            System.out.println("I am meeting from package b");
        }
        */
        // Meeting obj = new Meeting();
        // obj.printMsg();

        /*
        Following is the way to run the printMsg() function from the Meeting file
        public static void printMsg() {
           System.out.println("I am meeting from package b");
        }

        So if the function you are using is static somewhere then you can directly access it using the name of the class that function is in... But if it is not static there then you have to make an instance first and access the function via reference variable of that instance...
        */

        Meeting.printMsg();

        

    }
}


/*
----> To run this go to the pkg directory and open terminal there
----> After that, run the command javac a\Main.java a\Greeting1.java b\Greeting2.java 
----> After that, step out of the pkg folder in the directory by "cd.."
----> After that, run the command java -cp . pkg.a.Main
The -cp . specifies the current directory as part of the classpath.

*/