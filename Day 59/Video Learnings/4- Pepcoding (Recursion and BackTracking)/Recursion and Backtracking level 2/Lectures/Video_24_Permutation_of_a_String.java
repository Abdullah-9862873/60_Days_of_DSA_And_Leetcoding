// Boxes placed on the levels of recursion
import java.util.*;

public class Video_24_Permutation_of_a_String {
    public static void main(String[] args) {
        String str = "aabb";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int val = map.get(str.charAt(i));
                val++;
                map.remove(str.charAt(i));
                map.put(str.charAt(i), val);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        int currentBox = 0;
        int totalBoxes = 4;
        char[] boxes = new char[totalBoxes];

        printPermutations(currentBox, totalBoxes, boxes, str, map);
    }

    public static void printPermutations(int currentBox, int totalBoxes, char[] boxes, String str,
            HashMap<Character, Integer> map) {
        if (currentBox >= totalBoxes) {
            System.out.println(Arrays.toString(boxes));
            return;
        }


        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int val = entry.getValue();
            if (val > 0) {
                val--;
                map.put(ch, val);
                if (boxes[currentBox] == '\0') {
                    boxes[currentBox] = ch;
                    printPermutations(currentBox + 1, totalBoxes, boxes, str, map);
                    boxes[currentBox] = '\0';
                }
                val++;
                map.put(ch, val);
            }
        }

    }
}
