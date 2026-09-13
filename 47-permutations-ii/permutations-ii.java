import java.util.*;

class Solution {
    public void helper(int i, int[] nums, boolean[] vis, Set<List<Integer>> set,List<Integer> list, List<List<Integer>> ans) {

        if (list.size() == nums.length) {
            if (!set.contains(list)) {
                set.add(new ArrayList<>(list));
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (int j=0; j<nums.length; j++) {

            if (!vis[j]) {
                list.add(nums[j]);
                vis[j] = true;
                helper(i + 1, nums, vis, set,list,ans);
                list.remove(list.size()-1);
                vis[j] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        helper(0, nums, vis, new HashSet<>(), new ArrayList<>() ,ans);
        return ans;
    }
}