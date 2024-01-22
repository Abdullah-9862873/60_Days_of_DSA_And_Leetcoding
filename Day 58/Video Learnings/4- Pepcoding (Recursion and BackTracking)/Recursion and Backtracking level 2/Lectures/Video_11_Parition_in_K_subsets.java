import java.util.ArrayList;

public class Video_11_Parition_in_K_subsets {
    public static void main(String[] args) {
        int n = 6;
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
            for(int i=0; i<k; i++){
                ans.add(new ArrayList<>());
            }
            solve(1, n, k, 0, ans);
        }
    }

    public static void solve(int i, int n, int k, int noOfSets, ArrayList<ArrayList<Integer>> ans) {
        if(i>n){
            if(noOfSets == k){
                for(ArrayList<Integer> set : ans){
                    System.out.print(set + ",");
                }
                System.out.println();
            }
            return;
        }
        for(int j=0; j<ans.size(); j++){
            if(ans.get(j).size() > 0){
                // If there is already an answer present then simply add my number
                ans.get(j).add(i);
                solve(i+1, n, k, noOfSets, ans);
                ans.get(j).remove(ans.get(j).size()-1);
            }else{
                // If there is nothing then simply add number is the empty set
                ans.get(j).add(i);
                solve(i+1, n, k, noOfSets+1, ans);
                ans.get(j).remove(ans.get(j).size()-1);
                break;
            }
        }
    }

}
