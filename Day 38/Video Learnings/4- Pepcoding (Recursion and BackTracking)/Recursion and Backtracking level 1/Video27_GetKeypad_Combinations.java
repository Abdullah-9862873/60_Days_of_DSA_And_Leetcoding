import java.util.*;

public class Video27_GetKeypad_Combinations {
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

        String input = "678";
        System.out.println((getKeypadCombinations(input, map)).size());
        System.out.println(getKeypadCombinations(input, map));
    }

    public static ArrayList<String> getKeypadCombinations(String input, HashMap<Integer, String> map) {
        if (input.length() == 0) {
            ArrayList<String> str = new ArrayList<>();
            str.add("");
            return str;
        }
        char firstCharacter = input.charAt(0);
        ArrayList<String> recResponse = getKeypadCombinations(input.substring(1), map);
        ArrayList<String> myResponse = new ArrayList<>();

        // Traverse the recResponse
        int firstCharNumber = firstCharacter - '0';
        String str = map.get(firstCharNumber);
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            for(String temp : recResponse){
                myResponse.add(ch + temp);
            }
        }
        return myResponse;
    }

}
