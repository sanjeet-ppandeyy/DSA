class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum  = 0;
        while (j < n && sum < target){
            sum += nums[j++];
        }
        j--;
        while (i<n && j<n){
            int len = j-i+1;
            if (sum >= target) min = Math.min(min,len);
            sum -= nums[i];
            i++; j++;
            while (j < n && sum < target){
                sum += nums[j++];
            }
            j--;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}