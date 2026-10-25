import java.util.*;
class Solution {
    public boolean isIsland(int i, int j,int[][] grid) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length) return false;
        if(grid[i][j] == 1) return true;
        grid[i][j] = 1;
        boolean up = isIsland(i-1,j,grid);
        boolean down = isIsland(i+1,j,grid);
        boolean left = isIsland(i,j-1,grid);
        boolean right = isIsland(i,j+1,grid);
        return up && down && left && right;
    }
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0 && isIsland(i, j, grid)) count++;
            }
        }
        return count;
    }
}