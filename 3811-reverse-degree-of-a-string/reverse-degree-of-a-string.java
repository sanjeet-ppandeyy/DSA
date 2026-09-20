class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            int val = 26 - (s.charAt(i)-'a');
            ans += val * (i+1);
        }
        return ans;
    }
}