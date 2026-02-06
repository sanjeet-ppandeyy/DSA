class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int x = pq.remove();
            int y = pq.remove();
            if(x != y){
                int diff  = Math.abs(x-y);
                pq.add(diff);
            }
        }
        if(pq.size() == 0) return 0;
        return pq.peek();
    }
}