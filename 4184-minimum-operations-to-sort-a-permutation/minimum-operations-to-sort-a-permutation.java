class Solution {
    public boolean isInc(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[i] != (nums[i-1]+1)% n) return false;
        }
        return true;
    }
    public boolean isReverseInc(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] != (nums[i-1]-1+n)%n) return false;
        }
        return true;
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(isInc(nums) && nums[0] == 0) return 0;
        if(isInc(nums)) {
            int leftCount = n-nums[0];
            int rightCount = 1+(nums[n-1] + 1) + 1;
            return Math.min(leftCount, rightCount);
        }
        if (isReverseInc(nums)){
            int leftCount = n - nums[n-1] + 1;
            int rightCount = (nums[0]+1)%n + 1;
            return Math.min(leftCount, rightCount);
        }
        return -1;
    }
}
