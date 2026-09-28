class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++){
          char ch = s.charAt(i);
          if(ch =='('){
            st.push(ch);
            max = Math.max(max,st.size());
         }else if(ch==')')
           st.pop();
        }
        return max;
    }
}