
public class Introduction {
    public static void main(String[] args) {
        // int[] arr = new int[5];
    }
}

/*
 * ------------------------Notes------------------------
 * Array is a data structure which is basically a collection of same type of
 * data
 * 
 * 
 * This is basically the syntax of decalring and initialising arrays in java
 * 
 * datatype[] varName = new datatype[size]
 * 
 * or you can decalare the values directly like:
 * 
 * datatype[] varName = {value1, value2, value3}
 * 
 * 
 * --------------------------------------------------------
 * Things at the left hand side are executed and take memory and all at the
 * compile time...
 * 
 * While things at the right hand side are executed and take memory and all at
 * the run time...
 * new int[5] -----> This is known as dynamic memory allocation where the memory
 * is allocated at the run time...
 * 
 * -----------------------------------------------------------
 * 
 * In java Arrays objects are in heap so like
 * arr = [1,2,3,4]
 * 
 * The [1,2,3,4] is stored in the heap and the "arr" is pointing to that heap
 * 
 * --------------------------------------------------------------
 * In java language specification(JLS) it is mentioned that heap objects are not
 * continuous...
 * 
 * So following are the points to remember:
 * 
 * (1) ---> Array objects are stored in heap memory.
 * (2) ---> Heap objects are not continuous.
 * (3) ---> Dynamic memory allocation
 * Hence the array objects may not be continuous
 * 
 * So array objects are continuous or discontinuous, it depends on JVM
 * 
 * ------------------------------------------------------------------
 * For an integer array, by default all the values will be 0, For Example
 * 
 * int[] arr = new int[5]
 * 
 * here arr[0]...arr[4] will all give the value 0 as output
 * 
 * --------------------------------------------------------------------
 * In String array, be default all the values are "null"
 * ------------> null is basically a literal
 * 
 * --------------> Any reference variable has a by default value "null"
 * 
 * ----------------------------------------------------------------------
 * In int[] arr = new int[5]
 * 
 * This can be broken down to like "arr" is stored in the stack memory while the
 * objects are stored in the heap memory
 * 
 * And in the heap memory, there is an array like "[-,-,-,-,-]"....
 * 
 * Now each element in the above is basically an object itself and it is
 * basically a reference variable like
 * "[arr[0], arr[1], arr[2], arr[3], arr[4]]"
 * 
 * Now each reference variable of a non primitive data type like String has a by
 * default value of null so each of them has the value "null" in the memory
 * 
 * 
 */