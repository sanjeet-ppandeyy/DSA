class Solution {
    public TreeNode helper(int[] pre, int prelo, int prehi, int[] in, int inlo, int inhi){
        if(prelo>prehi) return null;
        TreeNode root = new TreeNode(pre[prelo]);
        int i = inlo;
        while(in[i] != pre[prelo]) i++;
        int leftSize = i - inlo;
        root.left = helper(pre,prelo+1,prelo+leftSize,in,inlo,i-1);
        root.right = helper(pre,prelo+leftSize+1,prehi,in,i+1,inhi);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
}