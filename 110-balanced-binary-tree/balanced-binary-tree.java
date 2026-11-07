class Solution {
    Map<TreeNode,Integer> map = new HashMap<>();
    public int height(TreeNode root){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int ans = 1 + Math.max(height(root.left),height(root.right));
        map.put(root,ans);
        return ans;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        int diff = Math.abs(left-right);
        if(diff > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}