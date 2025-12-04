class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode fwd = null;
        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode i = head;
        ListNode j = head.next;
        while(j != null){
            while(j!=null && j.val < i.val) j = j.next;
            i.next = j;
            i = j;
            if(j!=null) j = j.next;
        }
        head = reverse(head);
        return head;
    }
}