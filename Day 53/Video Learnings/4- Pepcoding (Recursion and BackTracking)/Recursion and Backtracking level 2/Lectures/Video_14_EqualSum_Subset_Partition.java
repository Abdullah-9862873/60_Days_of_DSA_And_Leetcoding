import java.util.*;

public class Video_14_EqualSum_Subset_Partition {
    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        if (n < k) {
            System.out.println("Not Possible");
        } else if (k == 1) {
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = ans * 10 + i;
            }
            System.out.println(ans);
        } else if (n == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append("(").append(i).append(")");
            }
            System.out.println(sb.toString());
        } else {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                ans.add(new ArrayList<>());
            }
            printKPartitions(1, n, k, 0, ans);
        }

    }

    public static void printKPartitions(int i, int n, int k, int noOfSets, ArrayList<ArrayList<Integer>> ans) {
        if (i > n) {
            if (noOfSets == k) {
                if (conditionSatisfied(ans)) {
                    for (ArrayList<Integer> temp : ans) {
                        System.out.print(temp);
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() > 0) {
                ans.get(j).add(i);
                printKPartitions(i + 1, n, k, noOfSets, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {
                ans.get(j).add(i);
                printKPartitions(i + 1, n, k, noOfSets + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }
    }

    public static boolean conditionSatisfied(ArrayList<ArrayList<Integer>> arr) {
        int expectedSum = 0;

        for (int i = 0; i < arr.get(0).size(); i++) {
            expectedSum += arr.get(0).get(i);
        }

        for (ArrayList<Integer> temp : arr) {
            int currentSum = 0;

            for (int temp2 : temp) {
                currentSum += temp2;
            }
            if (currentSum != expectedSum) {
                return false;
            }
        }
        return true;
    }
}
