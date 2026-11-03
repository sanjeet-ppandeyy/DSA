class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int tar = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            tar = Math.max(tar,nums[i]);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            count += tar - nums[i];
        }
        return count;
    }
}