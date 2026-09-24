import java.util.*;
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int m = queries.length;
        int[] result = new int[m];
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        
        int maxBeautySeen = 0;
        for (int i=0; i<n; i++) {
            maxBeautySeen = Math.max(maxBeautySeen, items[i][1]);
            items[i][1] = maxBeautySeen;
        }
        for (int i=0; i<m; i++) {
            int lo = 0;
            int hi = n-1;
            int ans = 0;
            while (lo <= hi) {
                int mid = lo+(hi-lo)/2;
                if (items[mid][0] <= queries[i]) {
                    ans = items[mid][1];
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
            result[i] = ans;
        }
        return result;
    }
}