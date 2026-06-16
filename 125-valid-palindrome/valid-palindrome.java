class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || 
                (ch >= 'A' && ch <= 'Z') || 
                (ch >= '0' && ch <= '9')) {

                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder rev = new StringBuilder(sb);
        rev.reverse();
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) != rev.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}