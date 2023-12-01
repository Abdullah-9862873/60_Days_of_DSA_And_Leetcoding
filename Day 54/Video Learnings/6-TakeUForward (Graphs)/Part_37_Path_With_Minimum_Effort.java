import java.util.*;
public class Part_37_Path_With_Minimum_Effort {
    public static class Tuple{
        int difference;
        int row;
        int col;

        public Tuple(int val1, int val2, int val3){
            this.difference = val1;
            this.row = val2;
            this.col = val3;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1,2,2},
            {3,8,2},
            {5,3,5},
        };
        int[] src = {0,0};
        int[] dst = {2,2};
        int minEffortFromAllPaths = getPathWithMinEffort(grid,src,dst);
        System.out.println(minEffortFromAllPaths);
    }
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public static int getPathWithMinEffort(int[][] grid, int[] src, int[] dst){
        int[][] differences = new int[grid.length][grid[0].length];
        for(int[] temp: differences){
            Arrays.fill(temp,Integer.MAX_VALUE);
        }

        differences[src[0]][src[1]] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.difference - y.difference);
        pq.add(new Tuple(0,src[0],src[1]));

        while(!pq.isEmpty()){
            Tuple top = pq.remove();
            int difference = top.difference;
            int row = top.row;
            int col = top.col;

            if(row == dst[0] && col == dst[1]){
                return difference;
            }

            for(int i=0; i<4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[newRow].length){
                    int currDiff = difference;
                    int newDiff = Math.abs(grid[newRow][newCol] - grid[row][col]);
                    int newEffort = Math.max(currDiff,newDiff);
                    if(newEffort < differences[newRow][newCol]){
                        differences[newRow][newCol] = newEffort;
                        pq.add(new Tuple(newEffort,newRow,newCol));
                    }
                }
            }
        }
        return 0;
    }
}
