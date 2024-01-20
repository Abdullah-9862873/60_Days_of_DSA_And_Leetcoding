public class Video_14_Print_Array_Reverse {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        printArray(arr, 0);
    }
    public static void printArray(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        printArray(arr, idx+1);
        System.out.println(arr[idx]);
    }
}
