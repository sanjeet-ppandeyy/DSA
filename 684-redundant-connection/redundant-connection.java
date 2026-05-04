import java.util.*;
class Solution {
    static int[] parent;
    static int[] size;
    public int leader(int u){
        if (parent[u] == u) return u;
        return parent[u] = leader(parent[u]);
    }
    public void union(int u, int v){
        u = leader(u);
        v = leader(v);
        if(u != v){
            if(size[u] > size[v]){
                parent[v] = u;
                size[u] += size[v];
            }else {
                parent[u] = v;
                size[v] += size[v];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for (int i=1; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        int[] ans = new int[2];
        for (int i=0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(leader(u) == leader(v)){
                ans[0] = u;
                ans[1] = v;
                break;
            }else union(u,v);
        }
        return ans;
    }
}