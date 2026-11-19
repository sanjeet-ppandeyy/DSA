class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long first = 0;
        long count = 0;
        long second = 0;
        for(int i=0; i<text.length(); i++) {
            if(text.charAt(i) == pattern.charAt(1)){
                second++;
                count += first;
            }
            if(text.charAt(i) == pattern.charAt(0)) first++;
        }
        return count + Math.max(first,second);
    }
}