class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] arr = new int[26];
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            arr[ch -'a']++;
        }
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(arr[ch - 'a'] == 1) return i;
        }
        return -1;
    }
}