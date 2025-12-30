class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = root.val;
        while(q.size()>0){
            int size = q.size();
        
            for(int i=0; i<size; i++){
                TreeNode temp = q.remove();
                if(i == 0) ans = temp.val;

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        return ans;
    }
}