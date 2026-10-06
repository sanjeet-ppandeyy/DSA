class Solution {
    public int minRotations(String s) {
        int curr = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            int rotate = s.charAt(i) - '0';
            int diff = Math.abs(curr - rotate);
            ans += Math.min(diff,10-diff);
            curr = rotate;
        }
        return ans;
    }
}