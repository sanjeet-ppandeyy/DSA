import java.util.*;
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int ans = 0;
        for(int k=1; k<=n; k++){
            if(n % k != 0) continue;
            boolean valid = true;
            for (int start = 0; start < n; start += k) {
                if (!checkRotation(nums, sorted, start, k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) ans += k;
        }
        return ans;
    }
    public boolean checkRotation(int[] nums, int[] sorted,int start,int k){
        int[] block = Arrays.copyOfRange(nums, start, start + k);
        int[] target = Arrays.copyOfRange(sorted, start, start + k);
        int[] doubled = new int[2 * k - 1];
        for (int i = 0; i < doubled.length; i++) doubled[i] = block[i % k];
        return KMP(doubled, target);
    }
    public int[] LPS(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern[i] == pattern[len]) lps[i++] = ++len;
            else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
    public boolean KMP(int[] text, int[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0) return true;
        if (m > n) return false;
        int[] lps = LPS(pattern);
        int i = 0, j = 0;
        while (i < n) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            }
            if (j == m) return true;
            else if (i < n && text[i] != pattern[j]) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return false;
    }
}