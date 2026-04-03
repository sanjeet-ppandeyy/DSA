import java.util.*;
class Triplet implements Comparable<Triplet> {
    int node;
    int parent;
    int cost;

    Triplet(int node, int parent, int cost) {
        this.node = node;
        this.parent = parent;
        this.cost = cost;
    }

    public int compareTo(Triplet t) {
        return this.cost - t.cost;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int sum = 0;
        boolean[] vis = new boolean[points.length];
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        while (pq.size()>0){
            Triplet top = pq.remove();
            int node = top.node;
            int cost = top.cost;
            if (vis[node]) continue;
            vis[node] = true;
            sum += cost;

            for(int i=0; i<points.length; i++){
                if(i==node) continue;
                int x1 = points[node][0], y1 = points[node][1];
                int x2 = points[i][0], y2 = points[i][1];
                int mDis = Math.abs(x2-x1) + Math.abs(y2-y1);
                if(!vis[i]) pq.add(new Triplet(i,node,mDis));
            }
        }
        return sum;
    }
}