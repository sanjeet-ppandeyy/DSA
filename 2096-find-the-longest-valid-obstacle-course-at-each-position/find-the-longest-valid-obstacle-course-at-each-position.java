import java.util.*;
class Solution {
    public int binarySearch(List<Integer> LIS, int target) {
        int low = 0;
        int high = LIS.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (LIS.get(mid) <= target) {
                low = mid + 1;
            }else high = mid;
        }
        return low;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        List<Integer> LIS = new ArrayList<>();
        for(int i=0 ;i<n ;i++){
            int idx = binarySearch(LIS,obstacles[i]);
            if(idx == LIS.size()) LIS.add(obstacles[i]);
            else LIS.set(idx,obstacles[i]);
            dp[i] = idx+1;
        }
        return dp;
    }
}