class Solution {
    static int idx;

    public TreeNode construct(int[] preorder, int[] postorder, int lo, int hi) {
        if (idx >= preorder.length || lo > hi) return null;

        TreeNode root = new TreeNode(preorder[idx++]);

        if (lo == hi) return root;

        int j = lo;   // FIXED
        while (postorder[j] != preorder[idx]) j++;

        root.left = construct(preorder, postorder, lo, j);
        root.right = construct(preorder, postorder, j + 1, hi - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        idx = 0;
        return construct(preorder, postorder, 0, postorder.length - 1);
    }
}