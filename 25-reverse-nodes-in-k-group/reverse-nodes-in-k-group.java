class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int c = k;
        ListNode curr = head, p = null, n = null;
        while(curr!=null && c > 0){
            n = curr.next;
            curr.next = p;
            p = curr;
            curr = n;
            c--;
        }
        if(curr == null && c>0){
            curr = p; p = null; n = null;
            while(curr!=null){
                n = curr.next;
                curr.next = p;
                p = curr;
                curr = n;
            }    

        }
        if(c > 0) return p;
        else head.next = reverseKGroup(curr,k);
        return p;
    }
}