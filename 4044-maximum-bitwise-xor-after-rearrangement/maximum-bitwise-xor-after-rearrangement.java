class Solution {
    public String maximumXor(String s, String t) {
        int count0 = 0;
        int count1 = 0;
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(ch == '0') count0++;
            else count1++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                if(count0>0){
                    sb.append('1');
                    count0--;
                }else
                    sb.append('0');
            }else{
                if(count1>0){
                    sb.append('1');
                    count1--;
                }else
                    sb.append('0');
            } 
        }
        return sb.toString();
    }
}