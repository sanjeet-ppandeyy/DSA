class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int i, int[] nums, List<Integer> list){
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(i+1,nums,list);
        list.remove(list.size()-1);
        helper(i+1,nums,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        helper(0,nums,new ArrayList<>());
        return ans;
    }
}