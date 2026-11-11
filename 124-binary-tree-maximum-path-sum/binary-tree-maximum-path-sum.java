class Solution {
    int maxSum;
    public int lineSum(TreeNode root) {
        if(root == null) return 0;
        int leftLine = lineSum(root.left);
        int rigthLine = lineSum(root.right);
        int pathSum = root.val;
        if(leftLine > 0) pathSum += leftLine;
        if(rigthLine > 0) pathSum += rigthLine;
        maxSum = Math.max(maxSum,pathSum);
        return root.val + (Math.max(0,Math.max(leftLine,rigthLine)));
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        lineSum(root);
        return maxSum;
    }
}