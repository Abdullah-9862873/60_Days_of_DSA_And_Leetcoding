import java.util.*;

public class Video12_Print_Palindromic_Permutations {
    public static void main(String[] args) {
        String str = "aaabb";
        Set<String> set = new HashSet<>();
        printPermutations(str, set);
        
        ArrayList<String> arraylist = new ArrayList<>(set);
        for(String temp : arraylist){
            if(checkPalindrome(temp)){
                System.out.println(temp);
            }
        }
    }

    public static void printPermutations(String str, Set<String> set) {
        if (str.isEmpty()) {
            set.add("");
            return;
        }

        char ch = str.charAt(0);
        String remaining = str.substring(1);
        printPermutations(remaining, set); 

        Set<String> newSet = new HashSet<>();
        for (String temp : set) {
            for (int i = 0; i <= temp.length(); i++) {
                StringBuilder sb = new StringBuilder(temp);
                sb.insert(i, ch);
                newSet.add(sb.toString());
            }
        }

        set.clear();
        set.addAll(newSet);
    }

    public static boolean checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
