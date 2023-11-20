import java.util.ArrayList;
import java.util.List;

public class Extra_Problem_01_Print_all_subarrays{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        List<List<Integer>> arraylist = new ArrayList<>();
        arraylist = findAllSubarrays(arr);
        for(List<Integer> myList : arraylist){
            System.out.println(myList);
        }
    }
    public static List<List<Integer>> findAllSubarrays(int[] arr){
        List<List<Integer>> arraylist = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            List<Integer> myList = new ArrayList<>();
            for(int j=i; j<arr.length; j++){
                myList.add(arr[j]);
                arraylist.add(new ArrayList<>(myList));
            }
        }

        return arraylist;
    }
}