class Solution {
    public boolean contain(TreeNode root, TreeNode node){
        if(root == null) return false;
        if(root == node) return true;
        return contain(root.left,node) || contain(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root) return root;
        boolean leftp = contain(root.left,p);
        boolean rightq = contain(root.right,q);
        if(leftp && rightq || !leftp && !rightq) return root;
        else if(!leftp || rightq) return lowestCommonAncestor(root.right,p,q);
        else return lowestCommonAncestor(root.left,p,q);
        
    }
}