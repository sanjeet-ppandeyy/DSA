import java.util.Arrays;
class Solution {
    static int mcm(int i, int j, int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int x = arr[j+1] - arr[i-1];
            int cost = x + mcm(i,k-1,arr,dp) + mcm(k+1,j,arr,dp);
            minCost = Math.min(minCost,cost);
        }
        return dp[i][j] = minCost;
    }
    public static int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] arr = new int[len+2];
        arr[0] = 0;
        for(int i=1; i<arr.length-1; i++) arr[i] = cuts[i-1];
        arr[len+1] = n;
        Arrays.sort(arr);
        int[][] dp = new int[arr.length-1][arr.length-1];
        for(int[] x : dp) Arrays.fill(x,-1);
        return mcm(1,arr.length-2,arr,dp);
    }
}