class Solution {
    public boolean isEqual(int[][] mat, int[][] target){
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
    public void rotate(int[][] mat){
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            int j = 0, k = n-1;
            while(j < k){
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
                j++;
                k--;
            }
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            if(isEqual(mat,target)) return true;
            rotate(mat);
        }
        return false;
    }
}