// Using 3 Sum algorithm
import java.util.*;
public class Problem_29_Triplet_sum_in_an_array {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int X = 13;

        boolean ans = findAns(arr, X);
        System.out.println(ans);
    }
    // Using Hashing Method
    // public static boolean findAns(int[] arr, int X){
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for(int i=0;i<arr.length; i++){
    //         map.put(arr[i], i);
    //     }

    //     for(int i=0; i<arr.length; i++){
    //         for(int j=i+1; j<arr.length; j++){
    //             int k = X - arr[i]-arr[j];
    //             if(map.containsKey(k)){
    //                 if(map.get(k) != i && map.get(k) != j){
    //                     return true;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }
    // Using two pointer
    public static boolean findAns(int[] arr, int X){
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(i>1 && arr[i] == arr[i-1]){
                continue;
            }
            int j = i+1;
            int k = arr.length-1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == X){
                    return true;
                }else if(sum < X){
                    j++;
                }else{
                    k--;
                }
            }

        }
        return false;
    }
}
