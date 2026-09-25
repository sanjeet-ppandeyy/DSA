class Solution {
    public int helper(int amount, int[] coins,int[] dp) {
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(dp[amount] != -1) return dp[amount];
        int ans = Integer.MAX_VALUE;
        for(int coin : coins) {
            int x = helper(amount-coin, coins,dp);
            if (x != Integer.MAX_VALUE) ans = Math.min(ans, x + 1);
        }
        return dp[amount] = ans;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = helper(amount, coins,dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}