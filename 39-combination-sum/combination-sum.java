import  java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int start, int sum, int[] candidates, int target, List<Integer> list) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                list.add(candidates[i]);
                helper(i,sum + candidates[i], candidates, target, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0,0,candidates, target, new ArrayList<>());
        return ans;
    }
}