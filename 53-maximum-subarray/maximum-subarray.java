class Solution {
    public int helper(int i,int sum, int maxSum, int[] nums,int[] dp){
        if(i == nums.length) return maxSum;
        sum += nums[i];
        maxSum = Math.max(maxSum,sum);
        if(sum < 0) sum = 0;
        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        return dp[i] = helper(i+1,sum,maxSum,nums,dp);
    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        return helper(0,0,Integer.MIN_VALUE,nums,dp);
    }
}