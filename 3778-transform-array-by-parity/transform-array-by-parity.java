class Solution {
    public int[] transformArray(int[] nums) {
        int countEven = 0;
        int countOdd = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 == 0) countEven++;
            else countOdd++;
        }
        int i = 0;
        while(countEven != 0){
            nums[i++] = 0;
            countEven--;
        }
        while(countOdd != 0){
            nums[i++] = 1;
            countOdd--;
        }
        return nums;
    }
}