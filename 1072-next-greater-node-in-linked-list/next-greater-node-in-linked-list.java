class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int[] arr = new int[len];
        int idx = 0;
        temp = head;
        while(temp != null){
            arr[idx++] = temp.val;
            temp = temp.next;
        }
        int n = arr.length;
        int[] nge = new int[n];
        nge[n-1] = 0;
        Stack<Integer> st = new Stack<>();
        st.push(arr[n-1]);
        for(int i=n-2; i>=0; i--){
            while(st.size() > 0 && st.peek() <= arr[i]) st.pop();
            if(st.size() == 0) nge[i] = 0;
            else nge[i] = st.peek();
            st.push(arr[i]);
        }
        return nge;
    }
}