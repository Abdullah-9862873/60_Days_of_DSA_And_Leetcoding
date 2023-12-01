public class Video_13_Print_Array{
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        printArray(arr, 0);
    }
    public static void printArray(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        printArray(arr, idx+1);
    }
}
