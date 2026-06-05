class Solution {
    public long minimumSteps(String s) {
        long swap = 0;
        long count0 = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '0') swap += count0;
            else count0++;
        }
        return swap;
    }
}