class Solution {
    int max  = 0;
    public int hight(TreeNode root){
        if(root == null) return 0;
        int left = 1 + hight(root.left);
        int right = 1 + hight(root.right);
        max = Math.max(left,right);
        return max;
    }
    public int maxDepth(TreeNode root) {
        hight(root);
        return max;
    }
}