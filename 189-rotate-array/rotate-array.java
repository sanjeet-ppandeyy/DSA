class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int id = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[id++] = nums[i];
        }
        int idx = 0;
            for (int i = n - k; i < n; i++) {
                nums[idx++] = nums[i];
        }
        for (int i = 0; i < n - k; i++) {
            nums[idx++] = arr[i];
        }
    }
}