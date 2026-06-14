class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int z = 0;
        for(int ele : nums){
            if(ele == 0) z++;
        }
        if(z == 0) return n-1;
        int i = 0, j = 0;
        int maxLen = 0;
        int zero = 0;

        while(i < n && nums[i] == 0) i++;
        if(i == n) return 0;
        j = i;

        while (j < n){
            if (nums[j] == 1) j++;
            else{
                if(zero == 0){
                    j++;
                    zero++;
                }else{
                    int len = j-i-1;
                    maxLen = Math.max(maxLen,len);
                    j++;
                    while(i<n && nums[i] == 1) i++;
                    i++;
                }
            }
        }
        if(zero == 0) return j-i;
        int len = j-i-1;
        maxLen = Math.max(maxLen,len);
        return maxLen;
    }
}