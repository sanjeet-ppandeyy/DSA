class Solution {
    public int findLongestChain(int[][] pairs) {
        int m = pairs.length;
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int count = 1;
        int b = pairs[0][1];
        for (int i = 1; i < m; i++) {
            if(pairs[i][0] > b){
                count++;
                b = pairs[i][1];
            }
        }
        return count;
    }
}