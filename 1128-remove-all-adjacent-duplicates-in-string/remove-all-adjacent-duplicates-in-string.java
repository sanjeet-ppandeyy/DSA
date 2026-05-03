class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(st.size() > 0 && st.peek() == ch) st.pop();
            else st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            char ch = st.pop();
            sb.append(ch);
        } 
         return sb.reverse().toString();
    }
}