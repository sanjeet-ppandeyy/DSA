class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans;
    }
    public void inOrder(TreeNode root,ArrayList<Integer> ans){
        if(root == null) return;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
}