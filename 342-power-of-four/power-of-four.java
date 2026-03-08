class Solution {
    // public boolean isPerfectSqrt(int n) {
    //     int root = (int)(Math.sqrt(n));
    //     return (root*root == n);
    // }
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        return ((n & (n-1)) == 0)  && (n%3 == 1);
    }
}