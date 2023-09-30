import java.util.*;
public class SubsequencesOfArray{
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        isTripletSumPresent(arr, 0);
    }
    public static void isTripletSumPresent(int[] arr, int X){
        // How many subsequences?? 2*n
        // int[] sumArray = new int[(int)Math.pow(arr.length,2)];

        // Generating all the subsequences
        for(int i=0; i<Math.pow(arr.length,2); i++){
            ArrayList<Integer> ansArray = new ArrayList<>();
            for(int j=0; j<arr.length; j++){
                if((i & (1<<j)) != 0){
                    ansArray.add(arr[j]);
                }
            }
            if(i != Math.pow(arr.length,2)-1){
                System.out.println(ansArray);
            }
        }

    }
}
