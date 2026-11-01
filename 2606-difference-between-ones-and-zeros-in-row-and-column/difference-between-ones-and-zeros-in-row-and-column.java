class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] oneInRow = new int[m][n];
        for(int i = 0; i < m; i++){
            oneInRow[i][0] = grid[i][0];
            for(int j = 1; j < n; j++){
                oneInRow[i][j] = oneInRow[i][j-1] + grid[i][j];
            }
        }
        int[][] oneInColumn = new int[m][n];
        for(int j = 0; j < n; j++){
            oneInColumn[0][j] = grid[0][j];
            for(int i = 1; i < m; i++){
                oneInColumn[i][j] = oneInColumn[i-1][j] + grid[i][j];
            }
        }
        int[][] diff = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int oneRow = oneInRow[i][n-1];
                int zeroRow = n - oneInRow[i][n-1];
                int oneColumn = oneInColumn[m-1][j];
                int zeroColumn = m - oneInColumn[m-1][j];
                diff[i][j] = oneRow + oneColumn - zeroRow - zeroColumn;
            }
        }
        return diff;
    }
}