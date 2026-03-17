class Solution {
    public int steps(int n, int[] dp){
        if(n==1 || n == 2) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = steps(n-1,dp) + steps(n-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return steps(n,dp);
    }
}