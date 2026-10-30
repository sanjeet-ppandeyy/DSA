import java.util.*;

class Pair{
    int node;
    int cost;
    Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
        }
        int[][] dis = new int[n][k+1];
        for(int i = 0; i < n; i++) Arrays.fill(dis[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        dis[0][1] = 0;
        pq.add(new int[]{0,0,1});
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int node = cur[0];
            int cost = cur[1];
            int count = cur[2];

            if(node == n-1) return cost;
            for(Pair p : adj.get(node)){
                int dist = p.cost+cost;
                int nextCount = (labels.charAt(node) == labels.charAt(p.node)) ? count + 1 : 1;
                if(nextCount <= k){
                    if(dis[p.node][nextCount] > dist){
                        dis[p.node][nextCount] = dist;
                        pq.add(new int[]{p.node,dist,nextCount});
                    }
                }
            }
        }
        return -1;
    }
}