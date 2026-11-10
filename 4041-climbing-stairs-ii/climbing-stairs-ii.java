class Solution {
    public int helper(int i, int[] costs,int[] dp){
        int n = costs.length;
        if(i == 0) return 0;
        if(dp[i-1] != Integer.MAX_VALUE) return dp[i-1];
        int oneStep = Integer.MAX_VALUE;
        int twoStep = Integer.MAX_VALUE;
        int thirdStep = Integer.MAX_VALUE;
        if(i >= 1) oneStep = costs[i-1] + 1 + helper(i-1,costs,dp);
        if(i >= 2)  twoStep = costs[i-1] + 4 + helper(i-2,costs,dp);
        if(i >= 3) thirdStep = costs[i-1] + 9 + helper(i-3,costs,dp);
        return dp[i-1] = Math.min(oneStep, Math.min(twoStep, thirdStep));
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return helper(n, costs,dp);
    }
}