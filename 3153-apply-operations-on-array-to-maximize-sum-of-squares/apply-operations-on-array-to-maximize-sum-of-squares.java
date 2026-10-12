class Solution {
    long MOD = 1_000_000_007L;
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        for(int n : nums) {
            for(int b=0; b<32; b++) {
                if ((n & (1 << b)) != 0) count[b]++;
            }
        }
        long ans = 0;
        while(k-- > 0) {
            long curr = 0;
            for (int b=0; b<32; b++) {
                if(count[b] > 0) {
                    count[b]--;
                    curr |= (1 << b);
                }
            }
            ans = (ans+(curr*curr)) % MOD;
        }

        return (int) ans;
    }
}