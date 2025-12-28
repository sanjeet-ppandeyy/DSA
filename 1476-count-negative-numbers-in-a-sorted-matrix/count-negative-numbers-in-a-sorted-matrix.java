class Solution {
    public int countNegatives(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            int lo=0, hi = n-1;
            int firstNeg = n;
            while(lo <= hi){
                int mid = (lo + hi)/2;
                if(arr[i][mid] < 0){
                    firstNeg = mid;
                    hi = mid -1;
                }else lo = mid + 1;
            }
            count += (n - firstNeg);
        }
        return count;
    }
}