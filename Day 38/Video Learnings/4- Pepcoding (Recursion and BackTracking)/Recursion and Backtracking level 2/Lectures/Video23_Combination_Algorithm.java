// Make Combination from permutation
// Placing Items on levels

import java.util.Arrays;

public class Video23_Combination_Algorithm {
    public static void main(String[] args) {
        int[] boxes = new int[4];
        int currentBox = 0;
        int num = 1;
        int boxesPlaced = 0;
        int totalBoxesToPlace = 3;
        printCombinations(boxes, currentBox, num, totalBoxesToPlace, boxesPlaced);
    }
    public static void printCombinations(int[] boxes, int currentBox, int num, int totalBoxesToPlace, int boxesPlaced) {
        if (boxesPlaced >= totalBoxesToPlace) {
            System.out.println(Arrays.toString(boxes));
            return;
        }

        for (int i = currentBox; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = num;
                printCombinations(boxes, i + 1, num, totalBoxesToPlace, boxesPlaced + 1);
                boxes[i] = 0;
            }
        }
    }
}
