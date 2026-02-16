class Solution {
    public int reverse(int n){
        int r = 0;
        while(n!=0){
            r = r*10 + n%10;
            n = n/10;
        }
        return r;
    }
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
            set.add(reverse(nums[i]));
        }
        return set.size();
    }
}