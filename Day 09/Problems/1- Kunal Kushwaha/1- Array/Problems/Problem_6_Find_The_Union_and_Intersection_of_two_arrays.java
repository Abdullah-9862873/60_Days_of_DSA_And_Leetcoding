import java.util.HashSet;
import java.util.Set;

public class Problem_6_Find_The_Union_and_Intersection_of_two_arrays {
    public static void main(String[] args) {
        int[] a = { 85, 9, 6, 99, 12 };
        int[] b = { 1, 12, 6 };
        int n = a.length;
        int m = b.length;

        Set<Integer> mySet = new HashSet<>();
        for(int i=0; i<n; i++){
            mySet.add(a[i]);
        }
        for(int i=0; i<m; i++){
            if(!mySet.contains(b[i])){
                mySet.add(b[i]);
            }
        }
        System.out.println(mySet.size());
    }
}