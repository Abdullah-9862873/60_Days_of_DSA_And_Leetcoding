/*
A Celibrity is a person
----> Who knows nobody
----> is known by everybody

like in the following matrix

0 1 1 1 1
1 0 0 1 0
1 0 0 1 0
0 0 0 0 0
0 1 0 1 0

So in this example 3 is celibrity as 3 does not know anything that is why there is 0
And everyone knows 3 look (0,3) (1,3) (2,3) (4,3) in all of the places there is 1

There can be cases in which there is no celebrity in the input... But this can never happen that there are multiple celebrities in an input
*/
import java.util.*;
public class Part_19_Celebrity_Problem {
    public static void main(String[] args) {
        boolean[][] arr = {
            {false, true, true, true, true},
            {true, false, false, true, false},
            {true, false, false, true, false},
            {false, false, false, false, false},
            {false, true, false, true, false},
        };
        int celebrity = findCelebrity(arr);
        System.out.println(celebrity);
    }
    public static int findCelebrity(boolean[][] arr){
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            st.push(i);
        }

        while(st.size() != 1){
            if(st.size() > 1){
                int a = st.pop();
                int b = st.pop();
                int ans = findRelation(a,b,arr);
                st.push(ans);
            }
        }
        // Now there is only one item in stack
        // This is a potential celebrity
        boolean ans = isPotentialCelebrityTheRealCelebrity(st.peek(), arr);
        if(ans){
            return st.peek();
        }
        return -1;
    }
    public static int findRelation(int a, int b, boolean[][] arr){
        boolean aKnowsb = arr[a][b];
        if(aKnowsb){
            return b;
        }
        return a;
    }
    public static boolean isPotentialCelebrityTheRealCelebrity(int peek, boolean[][] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[peek][i]){
                return false;
            }
            if(i != peek && arr[i][peek] != true){
                return false;
            }
        }
        return true;
    }
}
