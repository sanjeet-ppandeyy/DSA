class Solution {
    public int amount(int[] nums, int idx, int end, int[] dp) {
        int n = nums.length;
        if(idx > end) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = nums[idx] + amount(nums,idx+2,end,dp);
        int skip = amount(nums,idx+1,end,dp);
        return dp[idx] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int firstLo = amount(nums,0,n-2,dp1);
        int lastLo = amount(nums,1,n-1,dp2);
        return Math.max(firstLo,lastLo);
    }
}