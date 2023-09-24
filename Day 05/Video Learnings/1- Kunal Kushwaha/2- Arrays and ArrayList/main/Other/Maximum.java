
public class Maximum {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 55, 44, 22, 3, 7 };

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        System.out.print("The maximum value in these arrays is: " + max);
    }
}
