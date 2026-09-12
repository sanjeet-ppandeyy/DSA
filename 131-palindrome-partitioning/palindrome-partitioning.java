class Solution {
    List<List<String>> ans = new ArrayList<>();

    public static boolean isPalindrome(String s,int i,int j) {
        if(i >= j) return true;
        if(s.charAt(i) != s.charAt(j)) return false;
        return isPalindrome(s,i+1,j-1);
    }

    public void helper(String s,int i, List<String> list){
        if(i == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j=i; j<s.length(); j++){
            if(isPalindrome(s,i,j)){
                list.add(s.substring(i,j+1));
                helper(s,j+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        helper(s,0,new ArrayList<>());
        return ans;
    }
}