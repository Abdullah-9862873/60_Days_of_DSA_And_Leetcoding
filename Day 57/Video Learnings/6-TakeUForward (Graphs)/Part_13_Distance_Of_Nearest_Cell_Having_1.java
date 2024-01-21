import java.util.*;

public class Part_13_Distance_Of_Nearest_Cell_Having_1 {
    public static class Pair{
        int x;
        int y;
        int count;

        public Pair(int val1, int val2, int val3){
            this.x = val1;
            this.y = val2;
            this.count = val3;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {1,1,1},
        };
        int[][] ans = new int[grid.length][grid[0].length];
        computeAns(grid,ans);
        for(int[] temp: ans){
            System.out.println(Arrays.toString(temp));
        }
    }
    public static void computeAns(int[][] grid, int[][] ans){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 0){
                    ans[i][j] = 0;
                }else{
                    int min = findNearestDistance(grid,i,j);
                    ans[i][j] = min;
                }
            }
        }
    }
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public static int findNearestDistance(int[][] grid, int row, int col){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row,col,0));
        visited[row][col] = true;

        while(!q.isEmpty()){
            Pair top = q.remove();
            int x = top.x;
            int y = top.y;
            int count = top.count;

            for(int i=0; i<4; i++){
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                if(isValid(grid, adjx, adjy, visited)){
                    if(grid[adjx][adjy] == 1){
                        visited[adjx][adjy] = true;
                        q.add(new Pair(adjx,adjy,count+1));
                    }else{
                        return count+1;
                    }
                }

            }
            
        }
        return 0;
    }
    public static boolean isValid(int[][] grid, int row, int col, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]) {
            return false;
        }
        return true;
    }
    
}


// To optimize you can convert the 2D array into 1D array using
/*

To convert 2D array to 1D

boolean[] visited = new boolean[rows*cols];
for(int i=0; i<rows; i++){
    for(int j=0; j<cols; j++){
        visited[i*cols+j] = (Value set)
    }
}

*/