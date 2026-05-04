class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i); 
            if(ch == '[') count++;
            else count--;

            if(count < 0) balance = Math.max(balance,-count);
        }
        return (balance + 1) / 2;
    }
}