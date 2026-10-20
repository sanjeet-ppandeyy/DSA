class Solution {
    int lps(String s){
        int n = s.length();
        int[] lps = new int[n];
        int i = 1;
        int len = 0;
        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0) len = lps[len-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[n-1];
    }
    public String longestPrefix(String s) {
        int len = lps(s);
        return s.substring(0,len);
    }
}