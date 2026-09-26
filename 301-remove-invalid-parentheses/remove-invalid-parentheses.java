import java.util.*;
class Solution{
    public void helper(int i,String s,int left,int right,int balance,StringBuilder sb,Set<String> ans) {
        if(i == s.length()) {
            if(left == 0 && right == 0 && balance == 0) {
                ans.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(i);
        if(ch == '('){
            if(left > 0) helper(i+1, s, left-1, right, balance, sb, ans);
            sb.append(ch);
            helper(i + 1,s,left,right,balance+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }else if(ch == ')'){
            if (right > 0) helper(i+1,s,left,right-1,balance,sb,ans);
            if (balance > 0) {
                sb.append(ch);
                helper(i+1,s,left,right,balance-1,sb,ans);
                sb.deleteCharAt(sb.length()-1);
            }
        }else{
            sb.append(ch);
            helper(i+1,s,left,right,balance,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        int left = 0;
        int right = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') left++;
            else if (ch == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        helper(0,s,left,right,0,new StringBuilder(),ans);
        return new ArrayList<>(ans);
    }
}

