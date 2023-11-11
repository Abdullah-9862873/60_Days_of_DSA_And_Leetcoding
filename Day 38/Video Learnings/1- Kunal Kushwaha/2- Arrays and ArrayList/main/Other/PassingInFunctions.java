
import java.util.Arrays;

public class PassingInFunctions {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 54 };
        System.out.println(Arrays.toString(arr));

        changeTheValue(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void changeTheValue(int[] arr) {
        arr[1] = 99;
    }
}

/*------------------------------Notes-----------------------
 * ----> Strings are immutable in java but arrays are mutable(Can be changed) in java...
 * 
 * In the above example the function (changeTheValue) is changing the original value of arr as both are pointing to the same object in the heap memory
 */