class Solution {
    public int helper(int i,int j, int[][] matrix,int[][] dp){
        int m = matrix.length;
        int n = matrix[0].length;
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(matrix[i][j] == 0) return 0;
        int top = helper(i-1,j,matrix,dp);
        int left = helper(i,j-1,matrix,dp);
        int diagonal = helper(i-1,j-1,matrix,dp);
        return dp[i][j] = 1 + Math.min(top,Math.min(left,diagonal));
    }
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                count += helper(i,j,matrix,dp);
            }
        }
        return count;
    }
}