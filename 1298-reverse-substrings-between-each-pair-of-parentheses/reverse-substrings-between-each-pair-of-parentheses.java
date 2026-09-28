import java.util.*;
class Solution {
    public String reverseParentheses(String s) {
        int n =  s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '(') sb.append(st.pop());
                if(!st.isEmpty()) st.pop();
                for(int j=0; j<sb.length(); j++) st.push(sb.charAt(j));

            }else st.push(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : st) {
            ans.append(ch);
        }
        System.out.println(st);
        System.out.println(ans);
        return ans.toString();
    }
}