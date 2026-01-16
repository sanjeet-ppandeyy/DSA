class Solution {
    static int minDiff = Integer.MAX_VALUE;
    static TreeNode prev = null;
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null){
            int diff = Math.abs(root.val - prev.val);
            minDiff = Math.min(diff,minDiff);
        }
        prev = root;
        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return minDiff;
    }
}