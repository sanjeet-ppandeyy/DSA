import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int start, int sum, int[] candidates, int target, List<Integer> list) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (start >= candidates.length)  return;

            if (sum + candidates[start] <= target) {
                list.add(candidates[start]);
                helper(start, sum + candidates[start], candidates, target, list);
                list.remove(list.size() - 1);
            }
                helper(start+1,sum , candidates, target, list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0, 0, candidates, target, new ArrayList<>());
        return ans;
    }
}