class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr != null){
            int sum = 0;
            ListNode temp = curr.next;
            ListNode prev = curr;
            while(temp != null){
                sum = sum + temp.val;
                if(sum == 0) prev.next = temp.next;
                temp = temp.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}