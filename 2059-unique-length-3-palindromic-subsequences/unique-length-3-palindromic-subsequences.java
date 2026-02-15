class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character,Integer> first = new HashMap<>();
        HashMap<Character,Integer> last = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!first.containsKey(ch)) first.put(ch,i);
            last.put(ch,i);
        }
        int count = 0;
        for(char key : first.keySet()){
            int firstIdx = first.get(key);
            int lastIdx = last.get(key);
            Set<Character> set = new HashSet<>();
            for(int i=firstIdx+1; i<lastIdx; i++){
                set.add(s.charAt(i));
            }
            count += set.size();
        }
        return count;
    }
}