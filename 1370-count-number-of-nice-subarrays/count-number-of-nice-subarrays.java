import java.util.*;
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int x=0; x<n; x++) nums[x] %= 2;
        for(int x=1; x<n; x++) nums[x] += nums[x-1];
        
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x=0; x<n; x++){
            if (!map.containsKey(nums[x])) map.put(nums[x],x);
            int a = 0;
            if(map.containsKey(nums[x]-k)) a = map.get(nums[x]-k);
            int b = 0;
            if(map.containsKey(nums[x]-k+1)) b = map.get(nums[x]-k+1);
            if(nums[x] == k) count += b-a+1;
            if(nums[x] > k) count += (b-a);
        }
        return count;
    }
}