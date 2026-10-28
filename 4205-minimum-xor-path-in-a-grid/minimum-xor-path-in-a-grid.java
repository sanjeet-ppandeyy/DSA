class Solution {
    boolean[][][] dp;
    public int dfs(int i,int j,int xor,int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (i>=m || j>=n) return Integer.MAX_VALUE;
        xor ^= grid[i][j];
        if (i==m-1 && j==n-1) return xor;
        if (dp[i][j][xor]) return Integer.MAX_VALUE;
        dp[i][j][xor] = true;
        int right = dfs(i,j+1,xor,grid);
        int down = dfs(i+1,j,xor,grid);
        return Math.min(right,down);
    }
    public int minCost(int[][] grid) {
        dp = new boolean[grid.length][grid[0].length][1024];
        return dfs(0,0,0,grid);
    }
}