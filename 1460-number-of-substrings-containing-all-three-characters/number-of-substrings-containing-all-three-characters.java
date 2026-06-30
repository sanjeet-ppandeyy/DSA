class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int j = 0;
        int a = 0, b = 0, c = 0;
        for (int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            while (a > 0 && b > 0 && c > 0) {
                count += n - i;
                
                if (s.charAt(j) == 'a') a--;
                else if (s.charAt(j) == 'b') b--;
                else c--;
                j++;
            }
        }
        return count;
    }
}