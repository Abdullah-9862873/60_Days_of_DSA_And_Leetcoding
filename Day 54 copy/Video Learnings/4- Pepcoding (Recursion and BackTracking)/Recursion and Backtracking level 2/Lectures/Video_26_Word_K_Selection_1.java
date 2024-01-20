public class Video_26_Word_K_Selection_1 {
    public static void main(String[] args) {
        String str = "aabbbccdde";
        int k = 3;
        StringBuilder boxes = new StringBuilder();

        StringBuilder uniqueElementsBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (uniqueElementsBuilder.length() == 0 || str.charAt(i) != uniqueElementsBuilder.charAt(uniqueElementsBuilder.length() - 1)) {
                uniqueElementsBuilder.append(str.charAt(i));
            }
        }
        String uniqueElements = uniqueElementsBuilder.toString();

        int currentBox = 0;
        int selectionOfBoxesSoFar = 0;
        int selectionOfUniqueElementsSoFar = 0;
        printDistinctKWords(currentBox, selectionOfBoxesSoFar, selectionOfUniqueElementsSoFar, k, boxes, uniqueElements);
    }

    public static void printDistinctKWords(int currentBox, int ssf, int i, int k, StringBuilder boxes, String uniqueElements) {
        if (currentBox >= k) {
            if (ssf == k) {
                System.out.println(boxes);
            }
            return;
        }

        for (int j = i; j < uniqueElements.length(); j++) {
            if (boxes.length() <= ssf) {
                boxes.append(uniqueElements.charAt(j));
                printDistinctKWords(currentBox + 1, ssf + 1, j + 1, k, boxes, uniqueElements);
                boxes.deleteCharAt(boxes.length() - 1);
            }
        }
    }
}
