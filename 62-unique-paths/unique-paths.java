class Solution {
    public int helper(int m, int n,int[][] dp){
        if(m==1 || n==1) return 1;
        if(dp[m-1][n-1] != -1) return dp[m-1][n-1];
        return dp[m-1][n-1] = helper(m-1,n,dp) + helper(m,n-1,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(m,n,dp);
    }
}