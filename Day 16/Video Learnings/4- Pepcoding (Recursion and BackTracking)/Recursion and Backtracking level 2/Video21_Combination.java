/*
Question... Write all the combinations to place 1 item in 4 boxes
 */

public class Video21_Combination {
    public static void main(String[] args) {
        int currentBox = 0;
        int totalBoxes = 4;
        int selectionSoFar = 0;
        int totalSelection = 1;
        String answerSoFar = "";
        printCombination(currentBox, totalBoxes, selectionSoFar, totalSelection, answerSoFar);
    }
    public static void printCombination(int cb, int tb, int ssf, int ts, String asf) {
        if (cb >= tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        printCombination(cb + 1, tb, ssf + 1, ts, asf + "1"); // Yes Call
        printCombination(cb + 1, tb, ssf, ts, asf + "-"); // No Call

    }
}
