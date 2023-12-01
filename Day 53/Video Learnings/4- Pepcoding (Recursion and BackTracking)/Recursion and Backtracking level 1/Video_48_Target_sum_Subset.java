import java.util.ArrayList;

public class Video_48_Target_sum_Subset {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int target = 60;
        // For first method
        ArrayList<Integer> ans = new ArrayList<>();
        printTargetSumSubsetMethod1(arr, 0, target, 0, ans);

        // For second method
        printTargetSumSubset(arr, 0, target, 0, "");
    }

    public static void printTargetSumSubsetMethod1(int[] arr, int index, int target, int
    sumSoFar, ArrayList<Integer> ans) {
    if (sumSoFar == target) {
    System.out.println(ans);
    return;
    }

    if (index == arr.length) {
    return;
    }

    // Include the current element
    ans.add(arr[index]);
    printTargetSumSubsetMethod1(arr, index + 1, target, sumSoFar + arr[index], ans);

    // Exclude the current element
    ans.remove(ans.size() - 1);
    printTargetSumSubsetMethod1(arr, index + 1, target, sumSoFar, ans);
    }

    public static void printTargetSumSubset(int[] arr, int index, int target, int sumSoFar, String ans) {
        if (index == arr.length) {
            if (target == sumSoFar) {
                System.out.println(ans);
            }
            return;
        }

        printTargetSumSubset(arr, index + 1, target, sumSoFar + arr[index], ans + arr[index] + ",");
        printTargetSumSubset(arr, index + 1, target, sumSoFar, ans);
    }
}
