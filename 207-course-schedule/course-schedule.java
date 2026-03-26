class Solution {
    static boolean ans;
    public void dfs(int i,List<List<Integer>> adj,boolean[] vis,boolean[] path){
        vis[i] = true;
        path[i] = true;
        for(int ele : adj.get(i)){
            if(path[ele] == true){
                ans = false;
                return;
            }
            if(vis[ele] == false) dfs(ele,adj,vis,path);
        }
        path[i] = false;
    }
    public boolean canFinish(int n, int[][] pre) {
        ans = true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for (int i=0; i<pre.length; i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(a).add(b);
        }
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]) dfs(i,adj,vis,path);
        }
        return ans;
    }
}