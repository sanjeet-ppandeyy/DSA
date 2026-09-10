class Solution {
    int result=0;

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return result;
    }
    private int[] solve(TreeNode root){
        if(root==null) return new int[]{0,0};
        int sum=0;
        int count =0;
        int[] left = solve(root.left);
        int[] right =solve(root.right);
        sum+=left[0]+right[0]+root.val;
        count+=left[1]+right[1]+1;
        if(sum/count==root.val) result++;
        return new int[]{sum,count};
    }
}