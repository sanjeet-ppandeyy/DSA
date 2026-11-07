class Solution {
    public int countTree(int n){
        if(n == 0 || n == 1) return 1;
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += countTree(i) * countTree(n-i-1);
        }
        return ans;
    }
    public int numTrees(int n) {
        return countTree(n);
    }
}