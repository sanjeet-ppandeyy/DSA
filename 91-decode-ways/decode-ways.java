import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        if(s.charAt(0) == '0') return 0;
        return helper(0, s,dp);
    }

    private int helper(int i, String s,int[] dp) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        
        int takeOne = helper(i+1, s,dp);
        int takeTwo = 0;
        if(i + 1 < s.length()) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
            if(num <= 26) {
                takeTwo = helper(i+2, s,dp);
            }
        }
        return dp[i] = takeOne + takeTwo;
    }
}