class Solution {
    public static int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++){
            if(grid[i][0] == 0){
                for (int j=0; j<n; j++){
                    if (grid[i][j] == 0) grid[i][j] = 1;
                    else grid[i][j] = 0;
                }
            }
        }
         for (int j=1; j<n; j++){
             int count0 = 0, count1 = 0;
             for (int i=0; i<m; i++){
                 if (grid[i][j] == 0) count0++;
                 else count1++;
             }
             if(count0 > count1){
                 for (int i=0; i<m; i++){
                     if (grid[i][j] == 0) grid[i][j] = 1;
                     else grid[i][j] = 0;
                 }
             }
         }
         int score = 0;
         int x = 1;
         for (int j = n-1; j>=0; j--){
             for (int i=0; i<m; i++){
                 score += (grid[i][j] * x);
             }
             x *= 2;
         }
         return score;
    }
}