class Solution {
    public String lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }
        sb.reverse();
        return sb.toString();
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        String common = lcs(s1, s2);
        int i=0;
        int j=0;
        StringBuilder scs = new StringBuilder();
        for(int k=0; k<common.length(); k++) {
            while(s1.charAt(i) != common.charAt(k)) {
                scs.append(s1.charAt(i));
                i++;
            }
            while(s2.charAt(j) != common.charAt(k)) {
                scs.append(s2.charAt(j));
                j++;
            }
            scs.append(common.charAt(k));
            i++;
            j++;
        }
        while(i != s1.length()) scs.append(s1.charAt(i++));
        while(j != s2.length()) scs.append(s2.charAt(j++));
        return scs.toString();
    }
}