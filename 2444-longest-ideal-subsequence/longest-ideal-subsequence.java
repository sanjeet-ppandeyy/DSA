import java.util.*;
class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[26]; //dp[i] store the longest Ideal Subsequence at i
        for(int i=0; i<n; i++){
            int idx = s.charAt(i)-'a';
            int max = 0;
            for(int j = 0; j < 26; j++){
                if(Math.abs(idx-j) <= k){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[idx] = max+1;
        }
        int ans = 0;
        for(int x : dp) ans = Math.max(ans, x);
        return ans;
    }
}