class Solution {
    public int countSum(TreeNode root, int sum) {
        if (root == null) return sum;
        sum += root.val;
        sum = countSum(root.left, sum);
        sum = countSum(root.right, sum);

        return sum;
    }
    public int nodeCount(TreeNode root, int count) {
        if (root == null) return count;
        count++;
        count = nodeCount(root.left, count);
        count = nodeCount(root.right, count);
        return count;
    }
    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        count += averageOfSubtree(root.left);
        count += averageOfSubtree(root.right);
        int sum = countSum(root, 0);
        int nodes = nodeCount(root, 0);

        if (sum / nodes == root.val) {
            count++;
        }
        return count;
    }
}

