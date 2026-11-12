class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        HashMap<Integer,Long> sum = new HashMap<>();
        HashMap<Integer,Integer> count = new HashMap<>();

        for(int i=0; i<n; i++) {
            int num = nums[i];
            long s = sum.getOrDefault(num,0L);
            int c = count.getOrDefault(num,0);
            ans[i] += (long) i*c-s;
            sum.put(num,s+i);
            count.put(num,c+1);
        }
        sum.clear();
        count.clear();
        for(int i=n-1; i>=0; i--) {
            int num = nums[i];
            long s = sum.getOrDefault(num,0L);
            int c = count.getOrDefault(num,0);
            ans[i] += s - (long) i*c;
            sum.put(num,s+i);
            count.put(num,c+1);
        }
        return ans;
    }
}
