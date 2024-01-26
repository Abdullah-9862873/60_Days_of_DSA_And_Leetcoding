import java.util.*;

public class Video_43_Get_Permutations {
    public static void main(String[] args) {
        System.out.println(getPermutations("abc"));
    }

    public static ArrayList<String> getPermutations(String str) {
        if(str.length() == 0){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        char ch = str.charAt(0); // a
        ArrayList<String> recAns = getPermutations(str.substring(1));
        ArrayList<String> myAns = new ArrayList<>();

        for (int i = 0; i < recAns.size(); i++) {
            for (int j = 0; j <= recAns.get(i).length(); j++) { // 0 1 2
                StringBuilder sb = new StringBuilder(recAns.get(i));
                sb.insert(j, ch);
                myAns.add(sb.toString());
            }
        }
        return myAns;
    }
}
