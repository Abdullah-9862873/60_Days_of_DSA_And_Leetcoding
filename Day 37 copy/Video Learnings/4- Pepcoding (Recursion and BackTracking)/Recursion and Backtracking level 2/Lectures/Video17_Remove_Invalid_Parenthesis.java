import java.util.*;

public class Video17_Remove_Invalid_Parenthesis {
    public static void main(String[] args) {
        String input = "()())()";
        int minBrackets = getMinBrackets(input);
        HashSet<String> set = new HashSet<>();
        solve(input, minBrackets, set);
    }
    public static void solve(String str, int minBrackets, HashSet<String> set){
        if(minBrackets <= 0){
            if(isValid(str)){
                if(!set.contains(str)){
                    set.add(str);
                    System.out.println(str);
                }
            }
            return;
        }

        for(int i=0; i<str.length(); i++){
            if(minBrackets > 0){
                // Remove the ith character and pass the string to the next iteration with minBrackets-1
                StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(i);
                String remaining = sb.toString();
                solve(remaining, minBrackets-1, set);
            }
        }
    }

    // This function will give the minimum brackets that can be removed to make the
    // str valid
    public static int getMinBrackets(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                st.push(str.charAt(i));
            }else if(str.charAt(i) == ')'){
                if(st.size() == 0){
                    st.push(str.charAt(i));
                }else if(st.peek() == '('){
                    st.pop();
                }
                else if(st.peek() == ')'){
                    st.push(str.charAt(i));
                }
            }
        }return st.size();
    }
    public static boolean isValid(String str){
        int minimumBracketsToRemove = getMinBrackets(str);
        if(minimumBracketsToRemove == 0){
            return true;
        }
        return false;
    }
}