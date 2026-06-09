class Solution {
    public int bestClosingTime(String s) {
        int n = s.length();
        int[] pre = new int[n + 1];
        int[] suf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (s.charAt(i - 1) == 'N')
                pre[i]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (s.charAt(i) == 'Y')
                suf[i]++;
        }
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = pre[i] + suf[i];
        }
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            if (ans[i] < min) {
                min = ans[i];
                idx = i;
            }
        }
        return idx;
    }
}