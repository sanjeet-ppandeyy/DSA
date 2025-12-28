class Solution {
    public int countNegatives(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]<0) count++;
            }
        }
        return count;
    }
}