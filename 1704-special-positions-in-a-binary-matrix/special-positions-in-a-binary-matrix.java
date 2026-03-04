class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean flag = true;
                if(mat[i][j] == 1) {
                    for(int row=0; row<m; row++){
                        if(row == i) continue;
                        if(mat[row][j] == 1) flag = false;
                    }
                    for(int col=0; col<n; col++){
                        if(col == j) continue;
                        if(mat[i][col] == 1) flag = false;
                    }
                    if(flag) count++;
                }
            }
        }
        return count;
    }
}