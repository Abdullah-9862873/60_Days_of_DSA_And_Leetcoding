import java.util.*;

public class Video_20_Permutations {
    public static void main(String[] args) {
        int totalItems = 2;
        int currentItem = 1;
        int[] boxes = new int[4];
        // Question is that we have to arrange totalItems in the boxes
        printPermutations(boxes, currentItem, totalItems);
    }

    public static void printPermutations(int[] boxes, int currentItem, int totalItems) {
        if (currentItem > totalItems) {
            System.out.println(Arrays.toString(boxes));
            return;
        }

        for(int i=0; i<boxes.length; i++){
            if(boxes[i] == 0){
                boxes[i] = currentItem;
                printPermutations(boxes, currentItem+1, totalItems);
                boxes[i] = 0;
            }
        }

    }
}
/*
You have n boxes and you have r non-identical items and you have to place those non identical items in the n number of boxes with all the positions of those items possible in that boxes
 */
