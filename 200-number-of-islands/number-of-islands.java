class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        //top row-1,col
        if (i-1 >= 0 && grid[i - 1][j] == '1' && !vis[i- 1][j]) 
            dfs(i-1,j,grid,vis);
        //bottom row+1,col
        if (i+1 <= m-1 && grid[i + 1][j] == '1' && !vis[i + 1][j])
            dfs(i+1,j,grid,vis);
        //left row,col-1
        if (j-1 >= 0 && grid[i][j - 1] == '1' && !vis[i][j - 1])
            dfs(i,j-1,grid,vis);
        //right row,col+1
        if (j+1 <= n-1 && grid[i][j + 1] == '1' && !vis[i][j+ 1])
            dfs(i,j+1,grid,vis);
    }
}