class Solution {
    // F(2k) = F(k) * (2 * F(k+1) - F(k))
    // F(2k + 1) = F(k)^2 + F(k+1)^2
    long mod = 1000000007;

    public long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};

        long[] ans = fib(n/2);

        long a = ans[0]; // F(k)
        long b = ans[1]; // F(k+1)

        long c = (a * ((2 * b % mod - a + mod)) % mod);
        long d = ((a * a)%mod + (b * b)%mod) % mod;

        if (n%2 == 0) return new long[]{c, d};
        else return new long[]{d, (c + d) % mod};
    }
    public int countGoodStrings(long n) {
        long[] res = fib(n);
        return (int) ((2 * res[0])%mod);
    }
}