class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        for(int i=1; i<arr.length; i++){
            arr[i] ^= arr[i-1];
        }
        int[] ans = new int[m];
        for(int i=0; i<m; i++){
            int left = queries[i][0], right = queries[i][1];
            if(left == 0) ans[i] = arr[right];
            else ans[i] = arr[left-1] ^ arr[right];
        }
        return ans;
    }
}