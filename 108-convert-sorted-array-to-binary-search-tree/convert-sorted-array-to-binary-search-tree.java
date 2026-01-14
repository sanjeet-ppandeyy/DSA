class Solution {
    public TreeNode constructTree(int[] arr,int lo, int hi){
        if(lo>hi) return null;
        int mid = (lo+hi)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = constructTree(arr,lo,mid-1);
        root.right = constructTree(arr,mid+1,hi);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] arr) {
        return constructTree(arr,0,arr.length-1);
    }
}