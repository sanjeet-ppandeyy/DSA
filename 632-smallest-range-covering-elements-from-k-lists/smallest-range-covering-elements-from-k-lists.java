class Triplet implements Comparable<Triplet>{
    int ele;
    int row;
    int col;

    Triplet(int ele, int row, int col){
        this.ele = ele;
        this.row = row;
        this.col = col;
    }
    public int compareTo(Triplet p){
        return Integer.compare(this.ele,p.ele);
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int maxEle = Integer.MIN_VALUE;
        int n = nums.size();
        int[] ans = {0,Integer.MAX_VALUE};
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int ele = nums.get(i).get(0);
            pq.add(new Triplet(ele,i,0));
            maxEle = Math.max(maxEle,ele);
        }
        while(true){
            Triplet top = pq.remove();
            int ele = top.ele; int row = top.row; int col = top.col;
            if(maxEle-ele < ans[1] - ans[0]){
                ans[0] = ele;
                ans[1] = maxEle;
            }
            if(col == nums.get(row).size()-1) break;
            int next = nums.get(row).get(col+1);
            pq.add(new Triplet(next,row,col+1));
            maxEle = Math.max(next,maxEle);
        }
        return ans;
    }
}