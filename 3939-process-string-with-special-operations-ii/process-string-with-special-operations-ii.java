class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (len > 0) len--;
            }
            else if (ch == '#') len *= 2;
            else if (ch != '%') len++;
        }
        if (k >= len) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '%') {
                k = len - k-1;
            }
            else if (ch == '#') {
                len /= 2;
                if (k >= len) {
                    k -= len;
                }
            }
            else if (ch == '*'){
                if(len >0 ) len++;
            }
            else {
                if (len-1 == k) {
                    return ch;
                }
                len--;
            }
        }
        return '.';
    }
}