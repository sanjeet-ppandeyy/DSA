class Solution {
    public Node deepCopy(Node head1) {
        Node temp1 = head1;
        Node head2 = new Node(-1);
        Node temp2 = head2;

        while(temp1 != null){
            Node temp = new Node(temp1.val);
            temp2.next = temp;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        return head2.next;
    }
    public Node copyRandomList(Node head1) {
        //deep copy
        Node head2 = deepCopy(head1);

        HashMap<Node,Node> map = new HashMap<>();
        Node t1 = head1;
        Node t2 = head2;
        while(t1 != null){
            map.put(t1,t2);
            t1 = t1.next;
            t2 = t2.next;
        }
        for(Node original : map.keySet()){
            Node duplicate = map.get(original);
            if(original.random != null)
                duplicate.random = map.get(original.random);
        }
        return head2;    
    }
}