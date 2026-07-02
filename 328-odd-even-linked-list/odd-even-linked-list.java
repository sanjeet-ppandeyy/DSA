class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode t1 = odd;
        ListNode t2 = even;
        ListNode t = head;

        while (t != null) {
            t1.next = t;
            t = t.next;
            t1 = t1.next;

            t2.next = t;
            if (t == null)
                break;
            t = t.next;
            t2 = t2.next;

        }
        odd = odd.next;
        even = even.next;
        t1.next = even;
        return odd;
    }
}