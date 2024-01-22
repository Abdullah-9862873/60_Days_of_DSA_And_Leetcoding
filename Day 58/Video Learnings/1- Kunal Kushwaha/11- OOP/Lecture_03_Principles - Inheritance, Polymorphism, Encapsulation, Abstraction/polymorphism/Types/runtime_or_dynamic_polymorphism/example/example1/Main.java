package polymorphism.Types.runtime_or_dynamic_polymorphism.example.example1;

public class Main {
    public static void main(String[] args) { 
        Shapes sq2 = new Square();
        sq2.area(); // This will print the area of square because the object is of that square...
    }
}

/*

----> Here the preference is given to the area present in class "Square" because the object is of that type...
*/
