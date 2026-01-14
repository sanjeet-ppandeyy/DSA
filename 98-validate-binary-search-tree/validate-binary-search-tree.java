class Solution {
    static boolean flag = true;
    static TreeNode temp = null;
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(temp == null) temp = root;
        else if(root.val<=temp.val) flag = false;
        else temp = root;
        inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        temp = null;
        inorder(root);
        return flag;
    }
}