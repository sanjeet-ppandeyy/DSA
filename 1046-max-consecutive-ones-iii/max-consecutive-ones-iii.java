class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxOne = 0;
        int count0 = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            while (count0 > k) {
                if (nums[j] == 0) count0--;
                j++;
            }
            maxOne = Math.max(maxOne, i - j + 1);
        }
        return maxOne;
    }
}