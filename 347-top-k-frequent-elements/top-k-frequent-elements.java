class Pair implements Comparable<Pair>{
    int ele;
    int freq;
    
    Pair(int ele, int freq){
        this.ele = ele;
        this.freq = freq;
    }
    public int compareTo(Pair p){
        if(this.freq == p.freq) return this.ele - p.ele;
        return Integer.compare(this.freq,p.freq);
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int ele : nums){
            mp.put(ele,mp.getOrDefault(ele,0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int ele : mp.keySet()){
            int freq = mp.get(ele);
            pq.add(new Pair(ele,freq));
            if(pq.size() > k) pq.remove();
        }

        int[] ans = new int[pq.size()];
        int idx = 0;
        while(pq.size() > 0){
            ans[idx++] = pq.remove().ele;
        }
        return ans;
    }
}