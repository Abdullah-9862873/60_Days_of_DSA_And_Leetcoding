import java.util.*;

public class Video_06_Gold_Mine {
    public static void main(String[] args) {
        int[][] arr = {
            {10,0,100,0,0,8,0},
            {20,0,0,0,0,6,0},
            {30,0,0,9,12,3,4},
            {40,0,2,5,8,3,11},
            {0,0,0,0,0,9,0},
            {5,6,7,0,7,4,2},
            {8,9,10,0,1,10,8}
        };

        System.out.println(mineGold(arr));
    }

    public static int mineGold(int[][] arr){
        boolean[][] visited = new boolean[arr.length][arr.length];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] != 0 && !visited[i][j]){
                    ArrayList<Integer> bag = getGold(arr, i, j, visited);
                    
                    int sum = 0;
                    for(int k=0; k<bag.size(); k++){
                        sum += bag.get(k);
                    }
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }

    public static ArrayList<Integer> getGold(int[][] arr, int row, int col, boolean[][] visited){
        if(row < 0 || col < 0 || row >= arr.length || col >= arr.length || arr[row][col] == 0 || visited[row][col]){
            return new ArrayList<Integer>();
        }

        visited[row][col] = true;
        ArrayList<Integer> bag = new ArrayList<>();
        bag.add(arr[row][col]);

        bag.addAll(getGold(arr, row, col+1, visited));
        bag.addAll(getGold(arr, row, col-1, visited));
        bag.addAll(getGold(arr, row+1, col, visited));
        bag.addAll(getGold(arr, row-1, col, visited));

        return bag;
    }
}
