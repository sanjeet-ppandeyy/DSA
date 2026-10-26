class Solution {
    public int lcs(int i, int j, int[] nums1, int[] nums2,int[][] dp) {
        if(i==nums1.length || j==nums2.length) return Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        int pro = nums1[i] * nums2[j];
        int take = pro;
        if (i+1 < nums1.length && j+1 < nums2.length) {
            take = Math.max(take, pro + lcs(i+1,j+1,nums1,nums2,dp));
        }
        int skip1 = lcs(i,j+1,nums1,nums2,dp);
        int skip2 = lcs(i+1,j,nums1,nums2,dp);
        return dp[i][j] = Math.max(take, Math.max(skip1,skip2));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 0; i <= nums1.length; i++) Arrays.fill(dp[i],-1);
        return lcs(0,0,nums1,nums2,dp);
    }
}