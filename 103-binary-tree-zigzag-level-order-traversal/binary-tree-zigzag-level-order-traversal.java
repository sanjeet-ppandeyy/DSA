class Solution {
    public void nthLevel1(TreeNode root, List<Integer> ans, int n) {
        if (root == null) return;
        if (n == 1) {
            ans.add(root.val);
            return;
        }
            nthLevel1(root.left, ans, n - 1);
            nthLevel1(root.right, ans, n - 1);
        }
    public void nthLevel2(TreeNode root, List<Integer> ans, int n) {
        if (root == null) return;
        if (n == 1) {
            ans.add(root.val);
            return;
        }
            nthLevel2(root.right, ans, n - 1);
            nthLevel2(root.left, ans, n - 1);
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
            if(i%2 != 0) nthLevel1(root, result, i);
            else nthLevel2(root, result, i);
            ans.add(result);
        }
        return ans;
    }
}
