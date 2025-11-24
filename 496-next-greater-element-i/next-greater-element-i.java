class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            Stack<Integer> stack = new Stack<>();
            boolean found = false;

            for (int j = 0; j < nums2.length; j++) {
                if (!found && nums2[j] != target) {
                    stack.push(nums2[j]);
                } 
                else if (nums2[j] == target) {
                    found = true; 
                } 
                else if (found && nums2[j] > target) {
                    ans[i] = nums2[j];
                    found = false;
                    break;
                }
            }

            // If no greater element found
            if (found) ans[i] = -1;
        }

        return ans;
    }
}
