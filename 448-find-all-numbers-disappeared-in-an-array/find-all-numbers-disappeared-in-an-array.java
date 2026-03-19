class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(nums[i] != i+1 && !set.contains(i+1)) ans.add(i+1);
        }
        return ans;
    }
}