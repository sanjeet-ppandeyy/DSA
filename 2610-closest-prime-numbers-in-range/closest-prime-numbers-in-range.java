import java.util.*;
class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i=2; i*i<=right; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j<=right; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=left; i<=right; i++) {
            if (isPrime[i]) list.add(i);
        }
        
        if(list.size() < 2) return new int[]{-1, -1};
        
        int minGap = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for(int i = 1; i < list.size(); i++) {
            int gap = list.get(i) - list.get(i-1);
            if(gap < minGap) {
                minGap = gap;
                result[0] = list.get(i-1);
                result[1] = list.get(i);
            }
        }
        return result;
    }
}