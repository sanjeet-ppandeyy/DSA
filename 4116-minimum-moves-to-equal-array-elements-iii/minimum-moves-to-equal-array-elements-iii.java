class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int tar = nums[n-1];
        int count = 0;
        for(int i=0; i<n; i++){
            count += tar - nums[i];
        }
        return count;
    }
}