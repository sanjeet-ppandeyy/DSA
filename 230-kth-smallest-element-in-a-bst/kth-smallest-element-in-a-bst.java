class Solution {
    int k2;
    int ans;
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        k2--;
        if(k2==0) ans = root.val;
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        k2 = k;
        ans = -1;
        inorder(root);
        return ans;
    }
}