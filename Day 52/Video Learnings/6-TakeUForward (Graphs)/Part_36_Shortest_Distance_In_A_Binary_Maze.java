import java.util.*;
public class Part_36_Shortest_Distance_In_A_Binary_Maze {
    public static class Tuple{
        int distance;
        int row;
        int col;

        public Tuple(int val1, int val2, int val3){
            this.distance = val1;
            this.row = val2;
            this.col = val3;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1,1,1,1},
            {1,1,0,1},
            {1,1,1,1},
            {1,1,0,0},
            {1,0,0,0}
        };

        int[] src = {0,1};
        int[] dst = {2,2};

        int shortestDistance = getShortestDistance(grid,src,dst);
        System.out.println(shortestDistance);
    }
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public static int getShortestDistance(int[][] grid, int[] src, int[] dst){
        if(src[0] == dst[0] && src[1]==dst[1]){
            return 0;
        }

        int[][] gridDistances = new int[grid.length][grid[0].length];
        for(int[] it: gridDistances){
            Arrays.fill(it,Integer.MAX_VALUE);
        }

        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(0,src[0],src[1]));

        while(!q.isEmpty()){
            Tuple top = q.remove();
            int distance = top.distance;
            int row = top.row;
            int col = top.col;

            for(int i=0; i<4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[nRow].length && grid[nRow][nCol] == 1 && distance+1 < gridDistances[nRow][nCol]){
                    if(nRow == dst[0] && nCol == dst[1]){
                        return distance+1;
                    }
                    gridDistances[nRow][nCol] = distance+1;
                    q.add(new Tuple(distance+1,nRow,nCol));
                }
            }
        }
        return -1;
    }
}
