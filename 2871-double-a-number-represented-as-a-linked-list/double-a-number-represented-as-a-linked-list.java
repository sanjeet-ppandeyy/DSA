/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head){
        ListNode c = head, p = null, n = null;
        while(c != null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
    public ListNode doubleIt(ListNode head) {
        ListNode head2 = reverse(head);
        int carry = 0;
        ListNode temp = head2;
        while(temp != null){
            int doub = temp.val * 2 + carry;
            int val = doub % 10;
            carry = doub/10;
            temp.val = val;
            if(temp.next == null) break;
            temp = temp.next;
        }
        if(carry != 0){
            ListNode cn = new ListNode();
            cn.val = carry;
            temp.next = cn;
            cn.next = null;
        }
        return reverse(head2);
    }
}