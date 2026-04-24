class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode t = dummy;

        int carry = 0;
        while(t1 != null || t2 != null){
            int x, y;
            if(t1 != null) x = t1.val;
            else x = 0;

            if(t2 != null) y = t2.val;
            else y = 0;

            int sum = carry + x + y;
            carry = sum/10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            t.next = newNode;
            t = t.next;

            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }
        if(carry > 0){
            t.next = new ListNode(carry);
        }
        return dummy.next;
    }
}