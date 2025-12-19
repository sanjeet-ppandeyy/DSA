class Solution {

    public void nthLevel(TreeNode root, List<Integer> ans, int n,int t) {
        if (root == null) return;
        if (n == 1) {
            ans.add(root.val);
            return;
        }
        if (t%2 != 0) {
            nthLevel(root.left, ans, n - 1,t);
            nthLevel(root.right, ans, n - 1,t);
        } else {
            nthLevel(root.right, ans, n - 1,t);
            nthLevel(root.left, ans, n - 1,t);
        }
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int h = height(root);

        for (int i = 1; i <= h; i++) {
            List<Integer> result = new ArrayList<>();
            nthLevel(root, result, i,i);
            ans.add(result);
        }
        return ans;
    }
}
