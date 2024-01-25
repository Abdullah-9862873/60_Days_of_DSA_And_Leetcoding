package enumerations;

public class Introduction {
    enum Week implements A{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these are enum constants
        // public, static and final
        // since its final you cannot create child enums
        // type is Week

        // Abstracts are not allowed in enums since they dont allow others to override...Enums are designed to have a fixed number of instances, and each instance is expected to be complete and self-contained.
        void display() {

        }

        Week() {
            System.out.println("Constructor called for " + this);
        }

        @Override
        public void hello() {
            System.out.println("hey how are you");
        }
        // this is not public or protected, only private or default
        // why? we dont want to create new objects
        // this is not the enum concept, thats why

        // internally: public static final Week Monday = new Week();
    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;
        week.hello();
        System.out.println(Week.valueOf("Monday"));
//        for(Week day : Week.values()) {
//            System.out.println(day);
//        }

//        System.out.println(week.ordinal());
    }
}



/*
_______________________NOTES_______________________
Enums are basically used when we want to create fixed number of objects only... For example, if we have year class and we want that only 12 objects of this is allowed which are the names of the months in a year... Then we can specify it via enums...
*/