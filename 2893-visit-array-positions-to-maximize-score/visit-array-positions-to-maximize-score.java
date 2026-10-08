import java.util.*;
class Solution {
    public long maxScore(int[] nums, int x) {
        long[][] dp = new long[nums.length][2];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],Long.MAX_VALUE);
        return helper(0,nums[0]%2, nums,x,dp);
    }

    private long helper(int i,int parities, int[] nums, int x,long[][] dp) {
        if(i==nums.length) return 0;
        if(dp[i][parities] != Long.MAX_VALUE) return dp[i][parities];
        long skip = helper(i+1,parities,nums,x,dp);
        long pick = pick = nums[i] + helper(i+1,nums[i] % 2,nums,x,dp);
        if(nums[i] % 2 != parities) pick -= x;
        return dp[i][parities] = Math.max(skip,pick);
    }
}