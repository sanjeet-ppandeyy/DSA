import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> l: knowledge){
            map.put(l.get(0),l.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if(s.charAt(i)=='('){
                int j = i+1;
                while(j<s.length() && s.charAt(j) !=')') j++;
                String str = s.substring(i+1,j);
                if(map.containsKey(str)){
                    sb.append(map.get(str));
                    i = j+1;
                }else {
                    sb.append('?');
                    i = j+1;
                }
        
            }else{
                sb.append(s.charAt(i));
                i++;
            } 
        }
        return sb.toString();
    }
}