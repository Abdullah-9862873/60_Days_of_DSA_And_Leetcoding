import java.util.*;

public class Video28_K_Length_Words {
    public static void main(String[] args) {
        String str = "abcabc";
        int k = 2;

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        String uniqueElements = "";
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            uniqueElements += iterator.next();
        }
        StringBuilder boxes = new StringBuilder();
        printKLengthWords(uniqueElements, k, 0, boxes);
    }

    public static void printKLengthWords(String uniqueElements, int k, int boxesUsed, StringBuilder boxes) {
        if (boxesUsed >= k) {
            System.out.println(boxes.toString());
            return;
        }

        for (int i = 0; i < uniqueElements.length(); i++) {
            char currentChar = uniqueElements.charAt(i);
            if (boxes.indexOf(String.valueOf(currentChar)) == -1) {
                boxes.append(currentChar);
                printKLengthWords(uniqueElements, k, boxesUsed + 1, boxes);
                boxes.deleteCharAt(boxes.length() - 1);
            }
        }
    }
}
