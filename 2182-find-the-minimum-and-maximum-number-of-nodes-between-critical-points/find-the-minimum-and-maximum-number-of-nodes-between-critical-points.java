class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int [] ans = {-1,-1};
        int idx =1;
        int firstIdx = -1, lastIdx = -1;
        int minDist = Integer.MAX_VALUE;
        ListNode prev = head, curr = prev.next, nextEle = curr.next;
        if(nextEle == null) return ans;

        while(nextEle != null){
            if((curr.val > prev.val && curr.val > nextEle.val) || (curr.val < prev.val && curr.val < nextEle.val)){
                if(firstIdx==-1) firstIdx = idx;
                if(lastIdx!=-1){
                    int dist = idx - lastIdx;
                    minDist = Math.min(dist, minDist);
                }
                lastIdx = idx;
            }
            idx++;
            prev = prev.next;
            curr = curr.next;
            nextEle = nextEle.next;
        }
        int maxDist = lastIdx - firstIdx;
        if(maxDist == 0) maxDist = -1;
        if(minDist == Integer.MAX_VALUE) minDist = -1;
        ans[0] = minDist;
        ans[1] = maxDist;
        return ans;
    }
}