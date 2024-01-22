package polymorphism.example;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square sq = new Square();
        Triangle tr = new Triangle();
        
        shape.area();
        circle.area();
        sq.area();
        tr.area();

        Shapes sq2 = new Square();
        sq2.area(); // This will print the area of square because the object is of that square...
    }
}


/*
_______________________________NOTES_______________________________
----> Polymorphism can be seen here as the "area" is being represented in many ways... So we can say that same thing "area" is being represented in multiple ways...
*/
