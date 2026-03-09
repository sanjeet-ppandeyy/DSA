class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }
        int x = (xor & (xor-1));
        int mask = xor ^ x;
        int b1 = 0, b2 = 0;
        for(int ele : nums){
            if((mask & ele) == 0) b1 = b1 ^ ele;
            else b2 = b2 ^ ele; 
        }
        int[] ans = {b1,b2};
        return ans;
    }
}