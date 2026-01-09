class Solution {
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = height(root.left);
        int right = height(root.right);
        if(left == right) return root;
        if(left > right) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }
}