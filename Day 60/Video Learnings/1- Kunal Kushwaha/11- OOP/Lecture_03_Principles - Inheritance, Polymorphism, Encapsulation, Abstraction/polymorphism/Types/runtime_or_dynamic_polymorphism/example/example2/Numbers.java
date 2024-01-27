package Types.runtime_or_dynamic_polymorphism.example.example2;

public class Numbers {
    int num;

    public Numbers(int num){
        this.num = num;
    }

    @Override
    public String toString() {
        return "ObjectPrint = {" + this.num + "}";
    }

    public static void main(String[] args) {
        Numbers obj = new Numbers(6);
        System.out.println(obj);

        // Now here the java will print a hashcode when we try to print the object
        // But what if I want to print the num when someone tries to print the obj
        // We have to analyse the inner stuff of obj 
        // After analysing, we come to conclusion that println uses toString method to do so
        // So we have to override toString method here
    }
}
