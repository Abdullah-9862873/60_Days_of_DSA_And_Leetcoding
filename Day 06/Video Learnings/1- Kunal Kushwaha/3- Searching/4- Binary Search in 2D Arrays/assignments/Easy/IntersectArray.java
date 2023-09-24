import java.util.Arrays;
import java.util.HashSet;

public class IntersectArray {
    public static void main(String[] args){
        int[] num1 = {9,4,9,8,4};
        int[] num2 = {4,9,5};

        Arrays.sort(num1);
        Arrays.sort(num2);

        int p1 = 0;
        int p2 = 0;


        HashSet<Integer> intersect = new HashSet<>();
        while(p1 < num1.length && p2<num2.length){
            if(num1[p1] == num2[p2]){
                intersect.add(num1[p1]);
                p1++;
                p2++;
            }else if(num1[p1] < num2[p2]){
                p1++;
            }else if(num2[p2] < num1[p1]){
                p2++;
            }
        }
        System.out.println(intersect);
    }
}
