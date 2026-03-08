class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int k = 0;
        while(xor != 0){
            xor = xor & (xor-1);
            k++;
        }
        return k;
    }
}