class Solution {
    static boolean ans;
    public void bfs(int i,int[] vis, int[][] adj){
        vis[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            int color = vis[front];
            for(int ele : adj[front]){
                if(vis[ele] == vis[front]){
                    ans = false;
                    return;
                }
                if(vis[ele] == -1){
                    vis[ele] = 1-color;
                    q.add(ele);
                }
            }
        }
    }
    public boolean isBipartite(int[][] adj) {
        ans = true;
        int n = adj.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i=0; i<n; i++){
            if(ans == false) return ans;
            if(i==0 || vis[i] == -1) bfs(i,vis,adj);
        }
        return ans;
    }
}