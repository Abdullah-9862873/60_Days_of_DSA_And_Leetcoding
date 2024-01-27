package example.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Student abdullah = new Student(20, 90f);
        // Student ahmed = new Student(21, 92.4f);

        // if(abdullah.compareTo(ahmed) < 0){
        //     System.out.println("Abdullah has less marks than ahmed");
        // }else if(abdullah.compareTo(ahmed) > 0){
        //     System.out.println("Abdullah has more marks than ahmed");
        // }else{
        //     System.out.println("Both have equal marks");
        // }

        Student std1 = new Student(5, 69.9f);
        Student std2 = new Student(10, 80.2f);
        Student std3 = new Student(15, 74.3f);
        Student std4 = new Student(16, 72.0f);
        Student std5 = new Student(18, 98.2f);

        Student[] list = {std1, std2, std3, std4, std5};
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));

        // Internally the sort method will use the compareTo to compare and sort based on the marks of students

        // Initialisation of comparator inside the sort can also be done as
        Arrays.sort(list, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return (int)(o1.marks - o2.marks);
            }
        });

        // You can write the above same thing in lambda expression simply as:
        Arrays.sort(list, (o1,o2) -> (int)(o1.marks - o2.marks));
    }
}


/*
____________________________To Run___________________________
---> Follow the same steps that we used in the previous lectures...
______________________________NOTES____________________________
_____________________________why Error created________________________
---> If the Student class is something like the following i-e with no Comparable
public class Student {
    int rollNo;
    float marks;

    public Student(int rollNo, float marks){
        this.rollNo = rollNo;
        this.marks = marks;
    }
}

And we try to compare the objects like (abdullah < ahmed) than java cannot compare it...
_____________________________HOW TO COMPARE OBJECTS?_______________________
---> To compare the objects you need to use Comparable...
---> Comparable does: Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
*/