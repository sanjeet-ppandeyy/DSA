class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;

        int i = 0;
        int j = height.length - 1;
        int count = 0;

        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            if (leftMax < rightMax) {
                count += leftMax - height[i];
                i++;
            } else {
                count += rightMax-height[j];
                j--;
            }
        }
        return count;
    }
}