class Solution {
    public int lcs(int m, int n, String s1, String s2,int[][] dp) {
        if(m == 0 || n == 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        if(s1.charAt(m-1) == s2.charAt(n-1)) return dp[m][n] = 1 + lcs(m - 1, n - 1, s1, s2,dp);
        else return dp[m][n] = Math.max(lcs(m - 1, n, s1, s2,dp),lcs(m, n - 1, s1, s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i], -1);
        return lcs(m, n, text1, text2,dp);
    }
}