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
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        ListNode[] ans = new ListNode[k];
        temp = head;
        int avg = length / k;
        int extra = length % k;
        for(int i=0; i<k; i++){
            if(temp == null) break;
            ListNode curr = temp;
            ListNode prev = null;
            int len =0;

            while(temp != null && len < avg){
                prev = temp;
                temp = temp.next;
                len++;
            }
            if(extra > 0){
                prev = temp;
                temp = temp.next;
                extra--;
            }
            prev.next = null;
            ans[i] = curr;
        }
        return ans;
    }
}