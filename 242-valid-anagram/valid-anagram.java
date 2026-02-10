class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Integer> mp1 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(mp1.containsKey(ch)){
                int freq = mp1.get(ch);
                mp1.put(ch,freq+1);
            }
            else mp1.put(ch,1);
        }
        Map<Character,Integer> mp2 = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(mp2.containsKey(ch)){
                int freq = mp2.get(ch);
                mp2.put(ch,freq+1);
            }else mp2.put(ch,1);
        }
        for(char key : mp1.keySet()){
            if(!mp2.containsKey(key)) return false;
            if(!mp1.get(key).equals(mp2.get(key))) return false;
        }
        return true;
    }
}