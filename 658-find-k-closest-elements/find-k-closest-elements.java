class Pair implements Comparable<Pair>{
    int diff;
    int x;

    Pair(int diff, int x){
        this.diff = diff;
        this.x = x;
    }
    public int compareTo(Pair t){
        if(this.diff == t.diff){
            return Integer.compare(this.x, t.x); 
        }
        return Integer.compare(this.diff,t.diff);
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : arr){
            int diff = Math.abs(ele - x);
            pq.add(new Pair(diff,ele));
            if(pq.size()>k) pq.remove();
        }
        List<Integer> ans = new ArrayList<>();
        while(pq.size()>0){
            ans.add(pq.remove().x);
        }
        Collections.sort(ans);
        return ans;
    }
}