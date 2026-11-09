class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public long lcm(int a, int b) {
        return (long)(a/gcd(a,b)) * b;
    }
    public boolean repeatedStringMatch(String a, String b, int x, int y) {
        int lenA = a.length();
        int lenB = b.length();
        long m = (long) lenA * x;
        long n = (long) lenB * y;
        if (n > m) return false;
        long LCM = lcm(lenA, lenB);
        for (int i = 0; i < lenA; i++) {
            boolean matched = true;
            for (int j = 0; j < Math.min(n, LCM); j++) {
                if (b.charAt(j % lenB) != a.charAt((i + j) % lenA)) {
                    matched = false;
                    break;
                }
            }
            if (matched && i + n <= m) return true;
        }
        return false;
    }
}