class Solution {
    public void dfs(int start, List<List<Integer>> adj, boolean[] vis, int end) {
        vis[start] = true;
        for (int i : adj.get(start)) {
            if (!vis[i]) {
                dfs(i,adj,vis,end);
                if (i == end) return;
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end)
            return true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        dfs(start, adj, vis, end);
        return vis[end];
    }
}