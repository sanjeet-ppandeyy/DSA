class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxD = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(colors[i] != colors[j]){
                    int dis = Math.abs(i-j);
                    maxD = Math.max(maxD,dis);
                }
            }
        }
        return maxD;
    }
}