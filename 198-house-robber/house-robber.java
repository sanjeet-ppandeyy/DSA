class Solution {
    public int amount(int[] nums, int idx,int[] dp) {
        int n = nums.length;
        if(idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = nums[idx] + amount(nums,idx+2,dp);
        int skip = amount(nums,idx+1,dp);
        return dp[idx] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return amount(nums,0,dp);
    }
}