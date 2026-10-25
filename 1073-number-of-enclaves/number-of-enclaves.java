class Solution {
    public void isIsland(int i, int j,int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(grid[i][j] == 0) return;
        grid[i][j] = 0;
        isIsland(i-1,j,grid);
        isIsland(i+1,j,grid);
        isIsland(i,j-1,grid);
        isIsland(i,j+1,grid);
    }
    public int numEnclaves(int[][] grid) {
        for(int i=0; i<grid.length;i++) isIsland(i,0,grid);
        for(int j=0; j<grid[0].length;j++) isIsland(0,j,grid);
        for (int i = grid.length-1; i >= 0; i--) isIsland(i,grid[0].length-1,grid);
        for (int j = grid[0].length-1; j >= 0; j--) isIsland(grid.length-1, j,grid);
        int ans = 0;
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                if(grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }
}