import java.util.Arrays;

class Solution {
    int[][][] dp;
    int solve(int i, int M, int person, int[] piles){
        int n = piles.length;
        if(i >= n) return 0;
        if(dp[person][i][M] != 0) return dp[person][i][M];
        int ans = person == 1 ? -1 : Integer.MAX_VALUE;
        int stone = 0;
        for(int x=1; x<=Math.min(2*M,n-i); x++){
            stone += piles[i+x-1];
            if(person == 1) ans = Math.max(ans,stone + solve(i+x, Math.max(M, x), 0, piles));
            else ans = Math.min(ans,solve(i+x, Math.max(M, x), 1, piles));
        }
        return dp[person][i][M] = ans;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[2][n+1][n+1];
        return solve(0,1,1,piles);
    }
}