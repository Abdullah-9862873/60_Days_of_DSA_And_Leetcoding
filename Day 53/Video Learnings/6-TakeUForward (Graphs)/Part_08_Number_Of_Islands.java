/*
NUMBER OF COMPONENTS IN A MATRIX / NUMBER OF ISLANDS IN A MATRIX
______________________________________________________________________
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/
public class Part_08_Number_Of_Islands {
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'},
        };
        // 0-based indexing

        int islands = countNumberOfIslands(grid);
        System.out.println(islands);
    }
    public static int countNumberOfIslands(char[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    markVisited(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public static void markVisited(int i, int j, char[][] grid, boolean[][] visited){
        visited[i][j] = true;

        if(i > 0 && i <grid.length && j >= 0 && j < grid[i].length){
            if(!visited[i-1][j] && grid[i-1][j] == '1'){
                markVisited(i-1, j, grid, visited);
            }
        }
        if(i>=0 && i<grid.length-1 && j>= 0 && j<grid[i].length){
            if(!visited[i+1][j] && grid[i+1][j] == '1'){
                markVisited(i+1, j, grid, visited);
            }
        }
        if(i>=0 && i<grid.length && j>0 && j<grid[i].length){
            if(!visited[i][j-1] && grid[i][j-1] == '1'){
                markVisited(i, j-1, grid, visited);
            }
        }
        if(i>=0 && i<grid.length && j>=0 && j<grid[i].length-1){
            if(!visited[i][j+1] && grid[i][j+1] == '1'){
                markVisited(i, j+1, grid, visited);
            }
        }
    }
    
}
