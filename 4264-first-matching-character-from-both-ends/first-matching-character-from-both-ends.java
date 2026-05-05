class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        int i=0;
        int ans = -1;
        while(i<n){
            int j=n-i-1;
            if(s.charAt(i) == s.charAt(j)){
                ans = i;
                break;
            }
            i++;
        }
        return ans;
    }
}