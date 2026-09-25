class Solution {
    public String breakPalindrome(String s) {
        int n = s.length();
        if(n == 1) return "";

        char[] arr = new char[n];
        for(int i=0; i<n; i++){
            arr[i] = s.charAt(i);
        }

        for(int i=0; i<n/2; i++){
            if(arr[i] != 'a'){
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[n-1] = 'b';
        return new String(arr);
    }
}