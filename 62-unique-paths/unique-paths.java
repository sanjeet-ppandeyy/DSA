class Solution {
    public static int helper(int sr, int sc, int m, int n,int[][] dp){
        if(sr >= m || sc >= n) return 0;
        if(sr==m-1 && sc==n-1) return 1;
        if(dp[sr][sc] != 0) return dp[sr][sc];
        return dp[sr][sc] = helper(sr,sc+1,m,n,dp) + helper(sr+1,sc,m,n,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(0,0,m,n,dp);
    }
}