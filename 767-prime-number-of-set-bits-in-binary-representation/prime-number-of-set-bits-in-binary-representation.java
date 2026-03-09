class Solution {
    public int bitCount(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
            int mask = (1<<i);
            if((n&mask) != 0) count++;
        }
        return count;
    }
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i*i <= n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i=left; i<=right; i++){
            int setBit = bitCount(i);
            if(isPrime(setBit)) count++;
        }
        return count;
    }
}