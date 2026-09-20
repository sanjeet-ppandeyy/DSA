import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,k,n,new ArrayList<>(),ans);
        return ans;
    }

    private void helper(int i, int k, int n, List<Integer> list, List<List<Integer>> ans) {
        if(k==0 && n==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i > 9) return;
        list.add(i);
        helper(i+1,k-1,n-i,list,ans);
        list.remove(list.size()-1);
        helper(i+1,k,n,list,ans);
    }
}