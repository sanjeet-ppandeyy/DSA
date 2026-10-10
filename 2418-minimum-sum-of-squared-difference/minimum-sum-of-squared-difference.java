
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        long[] diff = new long[n];
        long max = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }
        
        if (k >= total) return 0;
        long low = 0, high = max;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long operations = 0;
            for (long d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }
            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        long level = low;
        long used = 0;
        long ans = 0;
        for (long d : diff) {
            if (d > level) {
                used += d - level;
                d = level;
            }

            ans += d * d;
        }
        long remaining = k - used;
        ans -= remaining * (2 * level - 1);
        return ans;
    }
}
