class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int total = (1<<n);
        for(int i=0; i<total; i++){
            List<Integer> ll = new ArrayList<>();
            for(int bitIdx=0; bitIdx<n; bitIdx++){
                int mask = (1<<bitIdx);
                if((i & mask) != 0) ll.add(nums[bitIdx]);
            }
            ans.add(ll);
        }
        return ans;
    }
}