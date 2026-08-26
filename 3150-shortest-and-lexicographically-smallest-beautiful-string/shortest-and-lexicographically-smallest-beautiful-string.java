public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int count1 = 0;
        int j = 0;
        int start = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && count1 < k) {
                if (s.charAt(j) == '1') {
                    count1++;
                }
                j++;
            }
            if (count1 == k) {
                while (i < j && s.charAt(i) == '0') {
                    i++;
                }
                int length = j - i;
                if (length < ans) {
                    ans = length;
                    start = i;
                }
                else if (length == ans) {
                    String curr = s.substring(i, j);
                    String prev = s.substring(start, start + ans);

                    if (curr.compareTo(prev) < 0) {
                        start = i;
                    }
                }
                if (s.charAt(i) == '1') {
                    count1--;
                }
            }
        }
        if (start == -1) {
            return "";
        }
        return s.substring(start, start + ans);
    }
}