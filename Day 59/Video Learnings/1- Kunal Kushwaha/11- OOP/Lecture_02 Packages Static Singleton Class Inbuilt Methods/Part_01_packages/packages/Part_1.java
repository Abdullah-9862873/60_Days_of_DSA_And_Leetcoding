package packages;
public class Part_1{
    public static void main(String[] args) {
        /*
        The following will print a random hash value... This is because, the "println" takes takes a string and use a toString method... And if the toString method is not present in the class then it will take default toString method... Which is nothing but the following:
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }   
        Thats why it is printing random hashcode

        What if I want it not to print the hashcode rather print name and INCREMENT??
        For this we can use Override method... That overrides the method of printing hashCode... Done in Lecture 3

        */
        A obj = new A("random");
        System.out.println(obj);
    }
}

class A{
    final int INCREMENT = 10;
    String name;

    A(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}


/*
_________________________________________________________________
What are packages in java?
---> Packages are containers to hold classes... Packages are basically folders to hold classes... 
---> Uses of Packages:
1) If you wanna have two classes with same name... You can keep them on two packages...
2) To manage the file structure and keep the code clean
_________________________________________________________________

*/