class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        dummy.next = head;
        head = dummy;
        
        while (temp != null) {
            while (temp.next != null && set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head.next;
    }
}