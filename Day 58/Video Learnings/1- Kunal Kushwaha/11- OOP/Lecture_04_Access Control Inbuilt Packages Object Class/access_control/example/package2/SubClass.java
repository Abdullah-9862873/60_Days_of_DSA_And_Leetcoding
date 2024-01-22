package example.package2;

public class SubClass extends B{
    public SubClass(int num, String name, int price){
        super(num, name, price);
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass(20,"Abdullah",500);
        System.out.println(obj.price);      // It can be accessed now
    }
}


/*
Same rule of protected is applied here which states, "inheritence involved same package"... So yes protected can be accessed here...
 */