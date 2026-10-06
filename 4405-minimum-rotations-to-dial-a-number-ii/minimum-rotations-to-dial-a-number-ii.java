class Solution {
    public int distance(int a,int b){
        int diff = Math.abs(a-b);
        return Math.min(diff,10-diff);
    }
    public int minRotations(int n, String s) {
        int normal = distance(0,s.charAt(0) - '0');
        for (int i = 1; i < s.length(); i++) {
            normal += distance(s.charAt(i-1)-'0',s.charAt(i)-'0');
        }
        int ans = normal;
        ans = Math.min(ans, normal - distance(0, s.charAt(0) - '0') + distance(0, s.charAt(n - 1) - '0'));
        for (int i = 1; i < s.length(); i++) {
            int curr = normal - distance(s.charAt(i-1)-'0',s.charAt(i)-'0') + distance(s.charAt(i-1)-'0',s.charAt(n-1)-'0');
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}