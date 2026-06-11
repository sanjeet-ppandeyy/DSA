import java.util.*;

class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<=n+1; i++) adj.add(new ArrayList<>());

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+2];

        q.add(1);
        vis[1] = true;
        int level = -1;

        while (q.size() > 0) {
            int size = q.size();
            level++;
            while (size > 0) {
                int node = q.remove();
                for (int ele : adj.get(node)) {
                    if (!vis[ele]) {
                        vis[ele] = true;
                        q.add(ele);
                    }
                }
                size--;
            }
        }
        return (int) pow(2,level-1);
    }
    public static long pow(long a , long b){
        if (b==0) return 1;
        long p = pow(a,b/2);
        if (b % 2 == 0) return (p * p) % 1000000007 ;
        else return (a * p * p) % 1000000007;
    }
}