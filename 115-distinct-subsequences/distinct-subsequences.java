import java.util.Arrays;
class Solution {
    public int helper(int i, int j,String s, String t,int[][] dp){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int pick = helper(i+1,j,s,t,dp);
        int skip = 0;
        if(s.charAt(i) == t.charAt(j)){
            skip = helper(i+1,j+1,s,t,dp);
        }
        return dp[i][j] = pick + skip;
    }
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i], -1);
        return helper(0,0,s,t,dp);
    }
}