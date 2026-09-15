import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = 1;
        for(int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }
        int j = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            while(j < m && nums[j] -  nums[i] < n) j++;
            max = Math.max(max, j-i);
        }
        return n-max;
    }
}