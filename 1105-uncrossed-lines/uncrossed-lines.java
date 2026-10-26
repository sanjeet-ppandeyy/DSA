import java.util.*;
class Solution {
    public int lcs(int i, int j, int[] nums1, int[] nums2,int[][] dp){
        if(i == nums1.length || j == nums2.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(nums1[i] == nums2[j]) return dp[i][j] = 1 + lcs(i+1,j+1, nums1, nums2,dp);
        return dp[i][j] = Math.max(lcs(i+1,j,nums1,nums2,dp),lcs(i,j+1,nums1,nums2,dp));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i], -1);
        return lcs(0,0,nums1,nums2,dp);
    }
}