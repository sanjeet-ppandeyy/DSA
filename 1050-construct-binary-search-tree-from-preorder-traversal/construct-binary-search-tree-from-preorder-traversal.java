class Solution {
    public TreeNode insert(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(root.val > val) root.left = insert(root.left,val);
        else root.right = insert(root.right,val);
        return root;
    }
    public TreeNode bstFromPreorder(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        for(int i=1; i<arr.length; i++){
            root = insert(root,arr[i]);
        }
        return root;
    }
}