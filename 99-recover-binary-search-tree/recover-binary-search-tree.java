class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    int idx = 0;
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        arr.add(root.val);
        helper(root.right);
    }
    public void fix(TreeNode root){
        if(root == null) return;
        fix(root.left);
        if(root.val != arr.get(idx)){
            root.val = arr.get(idx);
        }
        idx++;
        fix(root.right);
    }
    public void recoverTree(TreeNode root) {
        helper(root);
        Collections.sort(arr);
        fix(root);
    }
} 