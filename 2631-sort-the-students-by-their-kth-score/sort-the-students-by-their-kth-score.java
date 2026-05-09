import java.util.*;
class Pair implements Comparable<Pair>{
    int ele;
    int idx;
    Pair(int ele, int idx){
        this.ele = ele;
        this.idx = idx;
    }
    public int compareTo(Pair p){
        return Integer.compare(this.ele,p.ele);
    }
}
class Solution {
    public static int[][] sortTheStudents(int[][] score, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<score.length; i++){
            pq.add(new Pair(score[i][k],i));
        }
        int[][] ans = new int[score.length][];
        int idx = 0;
        while (pq.size() > 0){
            Pair top = pq.remove();
            ans[idx++] = score[top.idx];
        }
        return ans;
    }
}