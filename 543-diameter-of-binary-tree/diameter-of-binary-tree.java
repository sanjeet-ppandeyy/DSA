class Solution {
    int max;
    public int height(TreeNode root){
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        max = Math.max(max,(left + right));
        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        height(root);
        return max;
    }
}