import java.util.*;

public class Problem_20_Common_Elements {
    public static void main(String[] args) {
        int[] A = { 1, 5, 10, 20, 40, 80 };
        int[] B = { 6, 7, 20, 80, 100 };
        int[] C = { 3, 4, 15, 20, 30, 70, 80, 120 };
        ArrayList<Integer> ans = findCommonElements(A, B, C);
        System.out.println(ans);
    }

    public static ArrayList<Integer> findCommonElements(int[] A, int[] B, int[] C) {
        ArrayList<Integer> arr = new ArrayList<>();
        int pt1 = 0;
        int pt2 = 0;
        int pt3 = 0;

        while(pt1 < A.length && pt2<B.length && pt3<C.length){
            if(A[pt1] == B[pt2] && B[pt2] == C[pt3]){
                if(arr.isEmpty()){
                    arr.add(A[pt1]);
                }else{
                    if(arr.get(arr.size()-1) != A[pt1]){
                        arr.add(A[pt1]);
                    }
                }
                pt1++;
                pt2++;
                pt3++;
            }else if(A[pt1] < B[pt2] && A[pt1] < C[pt3]){
                // A is the smallest
                pt1++;
            }else if(B[pt2] < A[pt1] && B[pt2] < C[pt3]){
                // B is the smallest
                pt2++;
            }else if(C[pt3] < A[pt1] && C[pt3] < B[pt2]){
                // C is the smallest
                pt3++;
            }else if(A[pt1] == B[pt2] && B[pt2] != C[pt3]){
                // if A == B but B != C
                // Look for the smallest and make them go forward
                if(A[pt1] < C[pt3]){
                    pt1++;
                    pt2++;
                }else{
                    pt3++;
                }
            }else if(B[pt2] == C[pt3] && A[pt1] != B[pt2]){
                if(B[pt2] < A[pt1]){
                    pt2++;
                    pt3++;
                }else{
                    pt1++;
                }
            }else if(A[pt1] == C[pt3] && C[pt3] != B[pt2]){
                if(A[pt1] < B[pt2]){
                    pt1++;
                    pt3++;
                }else{
                    pt2++;
                }
            }
        }

        return arr;
    }
}
