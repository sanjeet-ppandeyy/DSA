class Solution{
    List<List<Integer>> ans=new ArrayList<>();
    Set<List<Integer>> set=new HashSet<>();

    public void helper(int i,int sum,int[] candidates,int target,List<Integer> list){
        if(sum==target){
            set.add(new ArrayList<>(list));
            return;
        }
        if(i>=candidates.length || sum > target)return;

        list.add(candidates[i]);
        helper(i+1,sum+candidates[i],candidates,target,list);
        list.remove(list.size()-1);
        
        int j=i+1;
        while(j < candidates.length && candidates[i] == candidates[j]) j++;
        helper(j,sum,candidates,target,list);

    }

    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        Arrays.sort(candidates);
        helper(0,0,candidates,target,new ArrayList<>());
        ans=new ArrayList<>(set);
        return ans;
    }
}