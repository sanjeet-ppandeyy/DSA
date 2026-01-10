class Solution {
    /*public void attach(TreeNode root, int val){
        if(root == null) return;
        if(root.val == val) return;
        if(root.left == null && root.right == null){
            TreeNode t = new TreeNode(val);
            if(root.val < val ) root.right = t;
            else root.left = t;
            return;
        }
        if(root.left == null && root.right != null){
            TreeNode t = new TreeNode(val);
            if(root.val < val ) root.right = t;
            else root.left = t;
            return;
        }
        if(root.val < val) attach(root.right,val);
        else attach(root.left,val);
    }
    */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)  return new TreeNode(val);
        if(root.val > val) {
            if(root.left == null && root.right == null){
                root.left = new TreeNode(val);
            }
            else root.left =insertIntoBST(root.left,val);
        }
        else{
            if(root.left == null && root.right == null){
                root.right = new TreeNode(val);
            }
            else root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}