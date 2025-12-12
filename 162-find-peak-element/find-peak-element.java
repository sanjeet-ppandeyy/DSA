class Solution {
    public int findPeakElement(int[] arr) {
       
        int  lo = 0, hi = arr.length-1;
        int ans = 0;
        while(lo < hi){
            int mid = (lo+hi)/2;
            if(arr[mid] < arr[mid+1]){
                lo = mid + 1;
            }else
             hi = mid ;   
        }     
        return lo;
    }
}