class Solution {
    public TreeNode helper(int[] inorder, int inlo, int inhi, int[] postorder, int posthi){
        if(inlo>inhi) return null;
        TreeNode root = new TreeNode(postorder[posthi]);
        int i = inlo;
        while(inorder[i] != postorder[posthi]) i++;
        int rightSize = inhi - i;
        root.left = helper(inorder,inlo,i-1,postorder,posthi - rightSize - 1);
        root.right = helper(inorder,i+1,inhi,postorder,posthi-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(inorder,0,n-1,postorder,n-1);
    }
}