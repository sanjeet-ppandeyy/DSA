class Solution {
    public int helper(int i,int sum, int maxSum, int[] nums){
        if(i == nums.length) return maxSum;
        sum += nums[i];
        maxSum = Math.max(maxSum,sum);
        if(sum < 0) sum = 0;
        return helper(i+1,sum,maxSum,nums);
    }
    public int maxSubArray(int[] nums) {
        return helper(0,0,Integer.MIN_VALUE,nums);
    }
}