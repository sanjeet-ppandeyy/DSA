import java.util.*;

class Solution {
    public void helper(int i, int j , int[][] grid,int[][] arr,int currMin) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length ||grid[i][j] == 0 || currMin >= arr[i][j]) return;
        arr[i][j] = currMin;
        helper(i,j-1,grid,arr,currMin+1);
        helper(i,j+1,grid,arr,currMin+1);
        helper(i-1,j,grid,arr,currMin+1);
        helper(i+1,j,grid,arr,currMin+1);
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr =  new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(arr[i],Integer.MAX_VALUE);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2) helper(i,j,grid,arr,0);
            }
        }
        int timeReq = 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j] == 1){
                    if(arr[i][j]==Integer.MAX_VALUE) return -1;
                    timeReq = Math.max(timeReq,arr[i][j]);
                }
        return timeReq;
    }
}