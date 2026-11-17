import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) ->{
            if(a[1] == b[1]) return b[0] - a[0];
            return a[1]-b[1];
        });
        List<Integer> dp = new ArrayList<>();
        for(int i=0; i<envelopes.length; i++){
            int lo = 0;
            int hi = dp.size();
            while(lo<hi){
                int mid = lo+(hi-lo)/2;
                if(dp.get(mid) < envelopes[i][0]) lo = mid+1;
                else hi = mid;
            }
            if(lo == dp.size()) dp.add(envelopes[i][0]);
            else dp.set(lo, envelopes[i][0]);
        }
        return dp.size();
    }
}