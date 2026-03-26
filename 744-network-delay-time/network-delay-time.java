class Pair implements Comparable<Pair>{
    int node;
    int dis;
    Pair(int node, int dis){
        this.node = node;
        this.dis = dis;
    }
    public int compareTo(Pair d){
        return Integer.compare(this.dis,d.dis);
    }
}

class Solution {
    public int networkDelayTime(int[][] edges, int n, int k){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
        }
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while (pq.size() > 0){
            Pair top = pq.remove();
            int node = top.node;
            int dis = top.dis;
            if(dis > ans[node]) continue;
            for (Pair p : adj.get(node)){
                int adjNode = p.node;
                int weight = p.dis;

                if(dis + weight < ans[adjNode]){
                    ans[adjNode] = dis + weight;
                    pq.add(new Pair(adjNode,ans[adjNode]));
                }
            }
        }
        int res = -1;
        for (int i=1; i<=n; i++){
            if(ans[i] == Integer.MAX_VALUE) return -1;
            if(ans[i] > res) res = ans[i];
        }
        return res;
    }
}

