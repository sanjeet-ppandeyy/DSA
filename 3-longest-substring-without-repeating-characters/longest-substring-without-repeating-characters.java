class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=1) return n;
        int i=0;
        int j = 0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<n){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>=i){
                int len = j-i;
                maxLen = Math.max(maxLen,len); 
                //i ko lekar jao ch ki purani position se ek aage.
                while(s.charAt(i) != ch) i++;
                i++; // ek aage nikalna hai
            }
            map.put(ch,j);
            j++;
        }
        int len = j-i;
        maxLen = Math.max(maxLen,len); 
        return maxLen;
    }
}