class Solution {
    public ListNode revese(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextt = null;
        while (curr != null) {
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = revese(slow.next);
        int maxSum = 0;
        ListNode p1 = head;
        ListNode p2 = slow.next;
        while (p2 != null) {
            int sum = p1.val + p2.val;
            if (sum > maxSum) {
                maxSum = sum;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return maxSum;
    }
}