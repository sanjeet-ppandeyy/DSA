class Solution {
    public TreeNode constructTree(ArrayList<Integer> arr,int lo, int hi){
        if(lo>hi) return null;
        int mid = (lo+hi)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = constructTree(arr,lo,mid-1);
        root.right = constructTree(arr,mid+1,hi);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head){
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        return constructTree(arr,0,arr.size()-1);
    }
}