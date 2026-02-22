class Solution {
    public int height(TreeNode root){
        if(root == null || root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int leftPart = diameterOfBinaryTree(root.left);
        int rightPart = diameterOfBinaryTree(root.right);
        int mid = height(root.left) + height(root.right);
        if(root.left != null) mid++;
        if(root.right != null) mid++;
        return Math.max(mid,Math.max(leftPart,rightPart));
    }
}