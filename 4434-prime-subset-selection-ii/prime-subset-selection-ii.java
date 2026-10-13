import java.util.*;

class Solution {
    int[][] dp;
    List<Integer> primes;
    int INF = 1000000;
    
    public int solve(int i, int sum) {
        if(sum == 0) return 0;
        if(i == primes.size() || sum < 0) return INF;
        if(dp[i][sum] != -1) return dp[i][sum];
        
        int skip = solve(i + 1, sum);
        int take = INF;
        int p = primes.get(i);

        if(p <= sum) {
            int result = solve(i + 1, sum - p);
            if (result != INF) take = 1 + result;
        }
        return dp[i][sum] = Math.min(take,skip);
    }
    public List<Integer> maxPrimeSubset(int n, int s) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i * i<=n; i++) {
            if(isPrime[i]) {
                for (int j=i*i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        primes = new ArrayList<>();
        for(int i=2; i<=n; i++) {
            if (isPrime[i] && i<=s) {
                primes.add(i);
            }
        }

        int m = primes.size();
        dp = new int[m+1][s+1];
        for (int[] i : dp) Arrays.fill(i,-1);
        
        int bestSum = s;
        while(bestSum > 0) {
            if(solve(0, bestSum) != INF) break;
            bestSum--;
        }
        if(bestSum == 0) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int remainingSum = bestSum;
        int remainingCount = solve(0, bestSum);
        while(i < m && remainingCount > 0) {
            int p = primes.get(i);

            if(p <= remainingSum && solve(i + 1, remainingSum-p) == remainingCount-1) {
                ans.add(p);
                remainingSum -= p;
                remainingCount--;
            }
            i++;
        }
        return ans;
    }
}