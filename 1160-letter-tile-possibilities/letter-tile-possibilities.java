class Solution {
    Set<String> set = new HashSet<>();
    public void helper(String s,String str, boolean[] vis){
        set.add(str);
        for(int i=0; i<s.length(); i++){
            if(!vis[i]){
                vis[i] = true;
                helper(s,str+s.charAt(i),vis);
                vis[i] = false;
            }
        }
    }
    public int numTilePossibilities(String s) {
        boolean[] vis = new boolean[s.length()];
        helper(s,"",vis);
        return set.size()-1;
    }
}