import java.util.*;
class Solution {
    int MOD = 1000000007;
    int[][][] dp;
    public int helper(int i, int j,int dir, int[][] grid) {
        if(i >= grid.length || j >= grid[0].length) return 0;
        if(dp[i][j][dir] != -1) return dp[i][j][dir];
        if(grid[i][j] == 1) {
            if(dir == 0) return helper(i+1,j,1,grid);
            else return helper(i,j+1,0,grid);
        }

        if(i == grid.length-1 && j==grid[0].length-1) return 1;
        int right = helper(i,j+1,0,grid);
        int down = helper(i+1,j,1,grid);
        return dp[i][j][dir] = (right+down) % MOD;
    }
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][2];
        for(int[][] arr : dp) {
            for(int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return helper(0, 0,0, grid);
    }
}