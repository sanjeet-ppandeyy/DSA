class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode leftSide = root.left;
        TreeNode rightSide = root.right;
        root.left = null;
        flatten(leftSide);
        flatten(rightSide);
        root.right = leftSide;
        TreeNode temp = leftSide;
        while(temp != null && temp.right != null) temp = temp.right;
        if(temp != null) temp.right = rightSide;
        else  root.right = rightSide;
        return;
    }
}