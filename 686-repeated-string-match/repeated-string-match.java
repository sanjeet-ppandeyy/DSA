class Solution {
    private int[] LPS(String b) {
        int m = b.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while(i < m) {
            if(b.charAt(i) == b.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }else {
                if(len != 0) len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    private boolean kmp(String a, String b, int[] lps,int totalLength) {
        int i = 0; 
        int j = 0;
        while(i < totalLength) {
            char ch = a.charAt(i % a.length());
            if (ch == b.charAt(j)) {
                i++;
                j++;
                if (j == b.length()) return true;
            }else {
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return false;
    }
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] lps = LPS(b);
        int k = (m+n-1)/n;
        
        for(int count=k; count<=k+1; count++) {
            if(kmp(a,b,lps,count*n)) return count;
        }
        return -1;
    }
}
