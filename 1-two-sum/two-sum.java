class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int remaning = target - nums[i];
            if(map.containsKey(remaning)) return new int[]{i, map.get(remaning)};
            else map.put(nums[i],i);
        }
        return new int[]{};
    }
}