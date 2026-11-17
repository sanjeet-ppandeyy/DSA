import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int lo = 0;
            int hi = dp.size();
            while(lo<hi){
                int mid = lo+(hi-lo)/2;
                if(dp.get(mid) < nums[i]) lo = mid+1;
                else hi = mid;
            }
            if(lo == dp.size()) dp.add(nums[i]);
            else dp.set(lo, nums[i]);
        }
        return dp.size();
    }
}