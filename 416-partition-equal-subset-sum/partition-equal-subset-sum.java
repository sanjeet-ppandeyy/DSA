class Solution {
    public boolean helper(int i, int[] nums,int sum,Boolean[][] dp){
        if(i >= nums.length || sum < 0) return false;
        if(sum == 0) return true;
        if(dp[i][sum] != null) return dp[i][sum];
        return dp[i][sum] = helper(i+1,nums,sum-nums[i],dp) || helper(i+1,nums,sum,dp);
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int x : nums) totalSum += x;
        if(totalSum% 2 != 0) return false;
        int sum = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length][sum+1];
        return helper(0,nums,sum,dp);
    }
}