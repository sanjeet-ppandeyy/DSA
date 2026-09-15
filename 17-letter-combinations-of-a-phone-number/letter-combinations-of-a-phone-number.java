import java.util.*;

class Solution {
    public void helper(int i,String digits, String[] arr, StringBuilder sb,List<String> ans){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = arr[digits.charAt(i) - '0'];
        for(int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));
            helper(i + 1, digits, arr, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs", "tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        helper(0, digits, arr, new StringBuilder(), ans);
        return ans;
    }
}