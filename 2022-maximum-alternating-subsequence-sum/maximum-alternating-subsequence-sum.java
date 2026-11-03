import java.util.Arrays;

class Solution {
    public long helper(int i, int[] nums, int idx, long[][] dp){
        if(i >= nums.length) return 0;
        if(dp[i][idx] != -1) return dp[i][idx];
        long skip = helper(i+1,nums,idx,dp);
        long take = 0;
        if(idx == 0){
             take = nums[i] + helper(i+1,nums,1,dp);
        }else {
            take = -nums[i] + helper(i+1, nums,0,dp);
        }
        return dp[i][idx] = Math.max(skip, take);
    }
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length+1][2];
        for ( int i=0; i<nums.length; i++ ) Arrays.fill(dp[i], -1);
        return helper(0, nums,0,dp);
    }
}