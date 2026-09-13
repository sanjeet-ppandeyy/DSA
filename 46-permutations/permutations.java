import java.util.*;

class Solution {
    public void helper(int i, int[] nums, boolean[] vis, List<Integer> list,List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j=0; j<nums.length; j++) {

            if (!vis[j]) {
                list.add(nums[j]);
                vis[j] = true;
                helper(i + 1, nums, vis, list,ans);
                list.remove(list.size() - 1);
                vis[j] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        helper(0, nums, vis, new ArrayList<>(),ans);
        return ans;
    }
}