import java.util.*;
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public void helper(int start, int n, int k, List<Integer> list) {
        if(k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(start > n) return;
        list.add(start);
        helper(start + 1, n, k - 1, list);
        list.remove(list.size() - 1);
        helper(start + 1, n, k, list);
    }
    public List<List<Integer>> combine(int n, int k) {
        helper(1, n, k, new ArrayList<>());
        return ans;
    }
}