class Solution {
    public int lcs(int m, int n, StringBuilder s1, StringBuilder s2,int[][] dp) {
        if(m == 0 || n == 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        if(s1.charAt(m-1) == s2.charAt(n-1)) return dp[m][n] = 1 + lcs(m-1,n-1,s1,s2,dp);
        else return dp[m][n] = Math.max(lcs(m - 1, n, s1, s2,dp),lcs(m,n-1,s1,s2,dp));
    }
    public int minInsertions(String s) {
       StringBuilder sb=new StringBuilder(s);
       int m =  sb.length();
       StringBuilder rev = new StringBuilder();
       for (int i=m-1; i>=0; i--) rev.append(sb.charAt(i));
       int[][] dp = new int[m+1][m+1];
       for(int i=1; i<=m; i++) Arrays.fill(dp[i],-1);
       return m - lcs(m,m,rev,sb,dp);
    }
}