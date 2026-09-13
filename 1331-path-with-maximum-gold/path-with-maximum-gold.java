class Solution {
    static int maxSum;
    public int getMaximumGold(int[][] grid) {
        maxSum = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[0].length; j++){
                helper(i,j,grid,0,vis);
            }
        }
        return maxSum;
    }
    private void helper(int i, int j, int[][] grid, int sum, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(grid[i][j] == 0 || visited[i][j]) return;

        sum += grid[i][j];
        if(sum > maxSum) maxSum = sum;

        visited[i][j] = true;
        helper(i+1, j, grid, sum, visited);
        helper(i, j+1, grid, sum, visited);
        helper(i-1, j, grid, sum, visited);
        helper(i, j-1, grid, sum, visited);
        visited[i][j] = false;
    }
}