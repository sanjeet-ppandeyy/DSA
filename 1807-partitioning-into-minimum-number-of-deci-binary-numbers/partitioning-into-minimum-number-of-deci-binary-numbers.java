class Solution {
    int ans = 0;
    public int minPartitions(String n) {
        for(int i=0; i<n.length(); i++){
            char ch = n.charAt(i);
            int num = ch - '0';
            ans = Math.max(ans,num);
        }
        return ans;
    }
}