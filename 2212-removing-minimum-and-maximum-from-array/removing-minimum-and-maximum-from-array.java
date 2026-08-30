import  java.util.*;

class Solution {
    public static int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);
        int deleteLeft = right + 1;
        int deleteRight = nums.length - left;
        int deleteBoth = (left + 1) + (nums.length - right);

        return Math.min(deleteLeft,Math.min(deleteRight, deleteBoth));
    }
}