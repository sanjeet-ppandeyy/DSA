class Solution {
    public TreeNode helper(int[] arr, int start, int end){
        if(start > end) return null;
        int idxMax = start;
        for(int i=start+1; i<=end; i++){
            if(arr[i] > arr[idxMax]) idxMax = i;
        }
        TreeNode root = new TreeNode(arr[idxMax]);
        root.left = helper(arr,start,idxMax-1);
        root.right = helper(arr,idxMax+1,end);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null) return null;
        TreeNode root = helper(nums,0,nums.length-1);
        return root;
    }
}