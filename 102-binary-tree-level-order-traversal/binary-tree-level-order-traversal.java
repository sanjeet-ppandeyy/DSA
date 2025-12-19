class Solution {
    public void nthLevel(TreeNode root, List<Integer> ans, int n) {
        if (root == null) return;
        if (n == 1) {
            ans.add(root.val);
            return;
        }
            nthLevel(root.left, ans, n - 1);
            nthLevel(root.right, ans, n - 1);
        }
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int h = height(root);

        for (int i = 1; i <= h; i++) {
            List<Integer> result = new ArrayList<>();
            nthLevel(root, result, i);
            ans.add(result);
        }
        return ans;
    }
}