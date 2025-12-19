class Solution {
    int max  = 0;
    public int height(TreeNode root){
        if(root == null) return 0;
        int left = 1 + height(root.left);
        int right = 1 + height(root.right);
        max = Math.max(left,right);
        return max;
    }
    public int maxDepth(TreeNode root) {
        height(root);
        return max;
    }
}