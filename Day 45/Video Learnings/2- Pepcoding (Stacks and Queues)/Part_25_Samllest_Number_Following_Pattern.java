import java.util.*;

public class Part_25_Samllest_Number_Following_Pattern {
    public static void main(String[] args) {
        String str = "IIIDIDDD";
        String ans = getSmallestNumberFollowingPattern(str);
        System.out.println(ans);
    }

    public static String getSmallestNumberFollowingPattern(String str) {
        String ans = "";
        int i = 1;
        Stack<Integer> st = new Stack<>();
        int j = 0;
        while (j < str.length()) {
            if (str.charAt(j) == 'D') {
                st.push(i);
                i++;
                j++;
            } else if (str.charAt(j) == 'I') {
                st.push(i);
                i++;
                j++;
                while (st.size() != 0) {
                    ans = ans + st.pop();
                }
            }
            if(j == str.length()){
                st.push(i);
                while(st.size() != 0){
                    ans = ans + st.pop();
                }
            }
        }
        return ans;
    }
}
