class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;
        return (total % 2 == 0) ? (n - 1) : 0;
    }
}
