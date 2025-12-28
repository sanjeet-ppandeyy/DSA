class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            int size = q.size();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                arr.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(arr);
        }
        return ans;
    }
}
