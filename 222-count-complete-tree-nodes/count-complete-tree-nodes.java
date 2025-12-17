class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        count += (1 + countNodes(root.left) + countNodes(root.right)); 
        return count;
    }
}