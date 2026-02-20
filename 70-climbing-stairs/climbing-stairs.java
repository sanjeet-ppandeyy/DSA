class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;

        int step1 = 3;
        int step2 = 2;
        int cur = 0;

        for (int i = 3; i < n; i++) {
            cur = step1 + step2;
            step2 = step1;
            step1 = cur;
        }

        return cur;        
    }
}