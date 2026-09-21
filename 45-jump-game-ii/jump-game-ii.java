class Solution {
    public int helper(int i, int[] nums,int[] dp) {
        if (i >= nums.length - 1) return 0;
        if(dp[i] != 0) return dp[i];
        int count = Integer.MAX_VALUE;
        for (int j=1; j<=nums[i]; j++) {
            if (i + j < nums.length) {
                int jumps = helper(i+j,nums,dp);

                if (jumps != Integer.MAX_VALUE) {
                    count = Math.min(count,1+jumps);
                }
            }
        }

        return dp[i] = count;
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        return helper(0, nums,dp);
    }
}