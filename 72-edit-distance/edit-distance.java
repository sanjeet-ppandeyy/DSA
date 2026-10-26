import java.util.*;
class Solution {
    public int helper(int m, int n, StringBuilder s1, StringBuilder s2,int[][] dp) {
        if(m < 0) return n+1;
        if(n < 0) return m+1;
        if(dp[m][n] != -1) return dp[m][n];
        if(s1.charAt(m) == s2.charAt(n)) return dp[m][n] = helper(m-1,n-1,s1,s2,dp);
        else{
            return dp[m][n] = 1 + Math.min(helper(m-1,n,s1,s2,dp),
                    Math.min(helper(m,n-1,s1,s2,dp),helper(m-1,n-1,s1,s2,dp)));
        }
    }
    public int minDistance(String word1, String word2) {
        StringBuilder s1 = new StringBuilder(word1);
        StringBuilder s2 = new StringBuilder(word2);
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return helper(m-1,n-1,s1,s2,dp);
    }
}