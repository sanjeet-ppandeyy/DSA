class Solution {
    public int path(int sr, int sc, int er, int ec,int[][] arr,int[][] dp){
        if(sr > er || sc > ec || sr<0 || sc<0) return 0;
        if(arr[sr][sc] == 1) return 0;
        if(sr == er && sc == ec) return 1;
        if(dp[sr][sc] != -1) return dp[sr][sc];
        return dp[sr][sc] = path(sr + 1, sc, er, ec,arr,dp) + path(sr, sc + 1, er, ec,arr,dp);
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length; 
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return path(0,0,m-1,n-1,arr,dp);
    }
}