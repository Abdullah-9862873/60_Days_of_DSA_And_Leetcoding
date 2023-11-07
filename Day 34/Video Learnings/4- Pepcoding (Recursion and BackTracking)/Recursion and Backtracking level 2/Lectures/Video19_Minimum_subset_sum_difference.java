import java.util.*;

public class Video19_Minimum_subset_sum_difference {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        String evenOrOdd = "";
        if (arr.length % 2 == 0) {
            evenOrOdd = "even";
        } else {
            evenOrOdd = "odd";
        }

        int[] minDifference = { Integer.MAX_VALUE };
        ArrayList<ArrayList<Integer>> result = minimumSubsetSumDifference(arr, 0, arr1, arr2, evenOrOdd, minDifference);

        if (result.size() == 2) {
            System.out.println("Minimum subset sum difference:");
            System.out.println(result.get(0));
            System.out.println(result.get(1));
        }
    }

    public static ArrayList<ArrayList<Integer>> minimumSubsetSumDifference(int[] arr, int index, ArrayList<Integer> arraylist1,
            ArrayList<Integer> arraylist2, String evenOrOdd, int[] minDifference) {
        if (index == arr.length) {
            if (evenOrOdd.equals("even")) {
                if (arraylist1.size() == arr.length / 2 && arraylist2.size() == arr.length / 2) {
                    int absDifference = absDifference(arraylist1, arraylist2);
                    if (absDifference < minDifference[0]) {
                        minDifference[0] = absDifference;
                        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
                        result.add(new ArrayList<>(arraylist1));
                        result.add(new ArrayList<>(arraylist2));
                        return result;
                    }
                }
            } else if (evenOrOdd.equals("odd")) {
                if ((arraylist1.size() == arr.length / 2 + 1 && arraylist2.size() == arr.length / 2)
                        || (arraylist1.size() == arr.length / 2 && arraylist2.size() == arr.length / 2 + 1)) {
                    int absDifference = absDifference(arraylist1, arraylist2);
                    if (absDifference < minDifference[0]) {
                        minDifference[0] = absDifference;
                        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
                        result.add(new ArrayList<>(arraylist1));
                        result.add(new ArrayList<>(arraylist2));
                        return result;
                    }
                }
            }
            return null;
        }

        arraylist1.add(arr[index]);
        ArrayList<ArrayList<Integer>> option1 = minimumSubsetSumDifference(arr, index + 1, arraylist1, arraylist2, evenOrOdd, minDifference);
        arraylist1.remove(arraylist1.size() - 1);

        arraylist2.add(arr[index]);
        ArrayList<ArrayList<Integer>> option2 = minimumSubsetSumDifference(arr, index + 1, arraylist1, arraylist2, evenOrOdd, minDifference);
        arraylist2.remove(arraylist2.size() - 1);

        if (option1 == null || (option2 != null && absDifference(option2.get(0), option2.get(1)) < absDifference(option1.get(0), option1.get(1)))) {
            return option2;
        } else {
            return option1;
        }
    }

    public static int absDifference(ArrayList<Integer> arraylist1, ArrayList<Integer> arraylist2) {
        int sum1 = 0;
        int sum2 = 0;

        for (int num : arraylist1) {
            sum1 += num;
        }

        for (int num : arraylist2) {
            sum2 += num;
        }

        return Math.abs(sum1 - sum2);
    }
}
