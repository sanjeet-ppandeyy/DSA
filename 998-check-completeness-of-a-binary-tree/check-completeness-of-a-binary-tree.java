class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean CBT = false;

        while (q.size() > 0) {
            TreeNode curr = q.poll();

            if (curr == null) {
                CBT = true;
            } else {
                if (CBT) return false;
                
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }
}
