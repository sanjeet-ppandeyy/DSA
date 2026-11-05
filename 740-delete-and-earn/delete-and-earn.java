class Solution {
    public int helper(int i, int[] nums,int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != -1)  return dp[i];
        int take = nums[i];
        int notTake = i+1;
        while(notTake < nums.length && nums[notTake] == nums[i]){
            take += nums[i];
            notTake++;
        }
        while(notTake < nums.length && nums[notTake] == nums[i]+1) notTake++;
        take += helper(notTake,nums,dp);
        int skip = helper(i+1,nums,dp);
        return dp[i] = Math.max(take,skip);
    }
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }
}