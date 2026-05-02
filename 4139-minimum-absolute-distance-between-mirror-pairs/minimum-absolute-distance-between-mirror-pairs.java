import java.util.*;

class Solution {
    public int reverse(int n){
        int r = 0;
        while (n > 0){
            r = r*10 + n%10;
            n/=10;
        }
        return r;
    }
    public int minMirrorPairDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0; i<nums.length; i++){
            int ele = nums[i];
            int rev = reverse(ele);
            if(map.containsKey(ele)){
                ans = Math.min(ans,Math.abs(i-map.get(nums[i])));
            }
            map.put(rev,i);
        }
        if (ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }
}