import java.util.*;
class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int p = part.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            st.push(ch);

            if(st.size() >= p){
                boolean flag = true;

                for (int j=p-1; j>=0; j--){
                    if (st.get(st.size() - p + j) != part.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for (int j=0; j<p; j++) st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() >0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}