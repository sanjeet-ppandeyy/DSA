class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.size()>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node temp = q.remove();
                if(i==size-1) temp.next = null;
                else temp.next = q.peek(); 
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            } 
        }
        return root;
    }
}