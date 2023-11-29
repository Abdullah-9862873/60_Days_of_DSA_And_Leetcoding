import java.util.*;

public class Part_10_Rotting_Oranges {
    public static class Pair{
        int row;
        int col;
        int time;
        public Pair(int val1, int val2, int val3){
            this.row = val1;
            this.col = val2;
            this.time = val3;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            // {2,1,1},
            // {1,1,0},
            // {1,0,1},
            {1,2},
        };
        int ans = countTimeToRotOranges(grid,0,0);
        System.out.println(ans);

    }
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public static int countTimeToRotOranges(int[][] grid, int row, int col){
        Queue<Pair> q = new ArrayDeque<>();
        int countFreshOranges = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    q.add(new Pair(i,j,0));
                }else{
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    countFreshOranges++;
                }
            }
        }
        if(countFreshOranges == 0){
            return 0;
        }
        int countHowManyWeRotted = 0;
        int totalTime = 0;

        while(!q.isEmpty()){
            Pair top = q.peek();
            int x = top.row;
            int y = top.col;
            int t = top.time;
            totalTime = Math.max(totalTime,t);
            q.remove();

            // Exploring all 4 directions
            for(int i=0; i<4; i++){
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                if(isValid(grid,visited,adjx,adjy)){
                    q.add(new Pair(adjx,adjy,t+1));
                    visited[adjx][adjy] = 2;
                    countHowManyWeRotted++;
                }
            }
        }

        if(countHowManyWeRotted != countFreshOranges){
            return -1;
        }
        return totalTime;
    }
    public static boolean isValid(int[][] grid, int[][] visited, int row, int col){
        if(row<0 || row>= grid.length || col<0 || col>=grid[row].length){
            return false;
        }

        if(visited[row][col] == 0 && grid[row][col] == 1){
            return true;
        }
        return false;
    }
}
