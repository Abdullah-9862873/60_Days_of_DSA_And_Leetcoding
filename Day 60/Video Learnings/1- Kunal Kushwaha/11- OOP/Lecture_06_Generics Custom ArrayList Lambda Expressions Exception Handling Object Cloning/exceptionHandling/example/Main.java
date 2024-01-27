package example;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try{
            int c = a/b;
            System.out.println(c);
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("normal exception");
        }finally{
            System.out.println("It will always execute");
        }

        System.out.println(divide(a, b));

    }
    static int divide(int a, int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("Can't divide by zero");
        }
        return a/b;
    }

    static int divide2(int a, int b) throws Exception{
        if(b == 0){
            throw new Exception("Can't divide by zero");
        }
        return a/b;
    }
}


/*
______________________________NOTES______________________________
_________________________Handling of unchecked exception_____________________
---> Here we know that dividing by zero gets the following exception:

Exception in thread "main" java.lang.ArithmeticException: / by zero

But we can print it in nice way by using try_catch... Because the exception created here is an arithematic exception, this is a unchecked exception so we can use try_catch block here...

______________________finally keyword__________________________
---> It is run even if the exception is thrown or not... So this is used to display a message like "File Closed"

______________________throw keyword______________________________
---> throw keyword is used to explicitly throw an exception... It is used in the functions when the method is not handling the exceptions locally... 

____________________Why 2 catch____________________________
---> In above code, 2 catches are made... First of all we know that the Arithematic exception is subclass of Exception... So above code means that if you get an arithematic exception then run the first catch but if any other type of exception is caught then run the second exception...
---> But if you do something like:
        catch(Exception e){

        }catch(ArithematicException e){

        }

Now, here it will throw compile-time check that the exceptions are already caught because arithematic exceptions are being caught in above catch because arithematic exceptions are included in Exception... So more restrict exceptions like arithematic exceptions should be declared first...

*/