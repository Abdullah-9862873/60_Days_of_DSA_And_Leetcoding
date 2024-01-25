import java.util.*;
public class Video_25_Subsequence {
    public static void main(String[] args) {
        System.out.println(printSubSequenceUsingRecursion("abc"));
    }
    public static ArrayList<String> printSubSequenceUsingRecursion(String str){
        if(str.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        char ch = str.charAt(0);
        String subStr = str.substring(1);
        ArrayList<String> recResponse = printSubSequenceUsingRecursion(subStr);

        ArrayList<String> myResponse = new ArrayList<>();
        for(String temp : recResponse){
            myResponse.add("" + temp);
            myResponse.add(ch + temp);
        }
        return myResponse;
    }
    // Using Power Set
    public static void printSubsequence(String str){
        for(int i=0; i<Math.pow(2,str.length()); i++){
            StringBuilder ans = new StringBuilder();
            for(int j=0; j<str.length(); j++){
                if((i & (1 << j)) != 0){
                    ans.append(str.charAt(j));
                }
            }
            System.out.println(ans);
        }
    }
}
