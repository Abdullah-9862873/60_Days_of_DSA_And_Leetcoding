package ownException;

public class Main{

    public static void main(String[] args) throws MyException {
        String name = "Abdullah";
        if(name.equals("Abdullah")){
           throw new MyException("name is Abdullah");
        }
    }
}
