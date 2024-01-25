import java.util.*;

public class Video_27_Word_K_Selection {
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
        char[] boxes = new char[k];
        printKSelectionWords(k, uniqueElements, 0, 0, boxes);
    }

    public static void printKSelectionWords(int k, String uniqueElements, int index, int ssf, char[] boxes) {
        if (ssf == k) {
            for (char box : boxes) {
                System.out.print(box);
            }
            System.out.println();
            return;
        }

        if (index == uniqueElements.length()) {
            return;
        }

        char currentChar = uniqueElements.charAt(index);

        boxes[ssf] = currentChar;
        printKSelectionWords(k, uniqueElements, index+1, ssf+1, boxes);
        boxes[ssf] = '\0'; // Reset the slot to empty
        printKSelectionWords(k, uniqueElements, index+1, ssf, boxes);
    }
}
