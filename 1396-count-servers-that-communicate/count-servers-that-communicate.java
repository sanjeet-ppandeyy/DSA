class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowC = new int[m];
        int[] colC = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    rowC[i]++;
                    colC[j]++;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (grid[i][j] == 1 && (rowC[i] > 1 || colC[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}