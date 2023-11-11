// Item placed on the level of recrusion
import java.util.*;

public class Video25_Permutation_of_a_String {
    public static void main(String[] args) {
        String str = "aabb";
        int currentBox = 0;
        int totalBoxes = 4;
        char[] boxes = new char[totalBoxes];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            if(!lastOccurence.containsKey(str.charAt(i))){
                lastOccurence.put(str.charAt(i),-1);
            }
        }
        printPermutation(str, currentBox, boxes, lastOccurence);
    }

    public static void printPermutation(String str,int currentBox, char[] boxes, HashMap<Character, Integer> lastOccurence) {
        if(currentBox >= str.length()){
            System.out.println(Arrays.toString(boxes));
            return;
        }
        
        char ch = str.charAt(currentBox);
        int lo = lastOccurence.get(ch);

        for(int i=lo+1; i<boxes.length; i++){
            if(boxes[i] == '\0'){
                boxes[i] = ch;
                lastOccurence.put(ch, i);
                printPermutation(str, currentBox+1, boxes, lastOccurence);
                lastOccurence.put(ch, lo);
                boxes[i] = '\0';
            }
        }

    }
}
