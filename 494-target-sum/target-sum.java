import java.util.*;

class Solution {
    static int sum;
    public int helper(int i, int[] nums,int res, int target,int[][] dp){
        if(i==nums.length){
            if(res == target) return 1;
            else return 0;
        }
        if(dp[i][sum + res]!= -1) return dp[i][sum + res];
        int add = helper(i+1,nums,res-nums[i],target,dp);
        int sub = helper(i+1,nums,res+nums[i],target,dp);
        return  dp[i][sum + res] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for(int i=0;i<nums.length;i++) sum += nums[i];
        int[][] dp = new int[nums.length][2*sum+1];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],-1);
        return helper(0,nums,0,target,dp);
    }
}