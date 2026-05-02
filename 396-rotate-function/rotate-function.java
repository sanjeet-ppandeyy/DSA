class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int t = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            t += i * nums[i];
        }
        int ans = t;

        for(int k=1; k<n; k++){
            t = t + sum - n* nums[n-k];
            ans = Math.max(ans,t);
        }
        return ans;
    }
}