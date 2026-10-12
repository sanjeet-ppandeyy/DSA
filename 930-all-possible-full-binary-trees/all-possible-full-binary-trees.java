class Solution {
    Map<Integer,List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(map.containsKey(n)) return map.get(n);
        List<TreeNode> ans = new ArrayList<>();
        if(n%2==0) return ans;
        if(n == 1) ans.add(new TreeNode(0));
        else{
            for(int i=1; i<n; i+=2){
                List<TreeNode> leftSubtree = allPossibleFBT(i);
                List<TreeNode> rigthSubtree = allPossibleFBT(n-1-i);

                for(TreeNode left : leftSubtree){
                    for(TreeNode right : rigthSubtree){
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
        }
        map.put(n,ans);
        return ans;
    }
}