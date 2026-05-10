class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        int[] ans = new int[m];
        for(int i=1; i<n; i++) nums[i] += nums[i-1];
        for(int i = 0; i < m; i++){
            int lo = 0;
            int hi = n - 1;
            int max = 0;
            while(lo <= hi){
                int mid = (lo + hi) / 2;
                if(nums[mid] > queries[i]) hi = mid - 1;
                else{
                    max = Math.max(max,mid+1);
                    lo = mid + 1;
                }
                ans[i] = max;
            }
        }
        return ans;
    }
}