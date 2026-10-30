import java.util.*;

class Solution {
    public int dfs(int i, int j, int[][] grid){
        if(i<0 || i >= grid.length || j<0 || j >= grid[0].length || grid[i][j] == 0 ) return 0;
        int area = grid[i][j];
        grid[i][j] = 0;
        area += dfs(i-1, j, grid);
        area += dfs(i+1, j, grid);
        area += dfs(i, j+1, grid);
        area += dfs(i, j-1, grid);
        return area;
    }
    public int findMaxFish(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }
}