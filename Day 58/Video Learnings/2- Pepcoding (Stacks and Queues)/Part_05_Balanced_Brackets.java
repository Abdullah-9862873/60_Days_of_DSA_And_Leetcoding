import java.util.Stack;

public class Part_05_Balanced_Brackets {
    public static void main(String[] args) {
        String input = "[(a+b) + {(c+d)*(e/f)}]";
        // String input = "[(a+b) + {(c+d)*(e/f)]}";
        // String input = "[(a+b) + {(c+d)*(e/f)}";
        // String input = "([(a+b) + {(c+d) * (e/f)}]";

        boolean ans = checkBalancing(input);
        System.out.println(ans);
    }
    public static boolean checkBalancing(String input){
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < input.length()){
            if(input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '['){
                st.push(input.charAt(i));
                i++;
            }else if(input.charAt(i) == ')'){
                if(st.size() > 0){
                    if(st.peek() == '('){
                        st.pop();
                        i++;
                    }else{
                        return false;
                    }
                }
            }else if(input.charAt(i) == '}'){
                if(st.size() > 0){
                    if(st.peek() == '{'){
                        st.pop();
                        i++;
                    }else{
                        return false;
                    }
                }
            }else if(input.charAt(i) == ']'){
                if(st.size() > 0){
                    if(st.peek() == '['){
                        st.pop();
                        i++;
                    }else{
                        return false;
                    }
                }
            }else{
                i++;
            }
        }

        if(st.size() != 0){
            return false;
        }
        return true; 
    }
}
