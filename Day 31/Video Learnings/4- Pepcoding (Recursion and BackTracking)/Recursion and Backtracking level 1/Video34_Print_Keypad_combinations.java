import java.util.*;

public class Video34_Print_Keypad_combinations {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "abc");
        map.put(2, "def");
        map.put(3, "ghi");
        map.put(4, "jkl");
        map.put(5, "mno");
        map.put(6, "pqrs");
        map.put(7, "tu");
        map.put(8, "vwx");
        map.put(9, "yz");
        map.put(0, ".;");

        String input = "67";
        printKeypadCombinations(input, map, "");

    }
    public static void printKeypadCombinations(String input, HashMap<Integer, String> map, String ans){
        if(input.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = input.charAt(0);
        String ros = input.substring(1);
        int num = ch - '0';
        String str = map.get(num);      // pqrs
        for(int i=0; i<str.length(); i++){
            char cho = str.charAt(i);
            printKeypadCombinations(ros, map, ans + cho);
        }
    }
}
