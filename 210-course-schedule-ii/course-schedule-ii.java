class Solution {
    public void bfs(int[] inDeg, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> arr) {
        int n = inDeg.length;
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            if (inDeg[j] == 0)
                q.add(j);
        }
        while (!q.isEmpty()) {
            int front = q.remove();
            arr.add(front);
            for (int ele : adj.get(front)) {
                inDeg[ele]--;
                if (inDeg[ele] == 0) {
                    q.add(ele);
                }
            }
        }
    }
    public int[] findOrder(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int edge = edges.length;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            adj.add(arr);
        }
        for (int i = 0; i < edge; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            adj.get(y).add(x);
        }
        int[] inDeg = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : adj.get(u)) {
                inDeg[v]++;
            }
        }
        boolean check = false;
        int[] ans = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        bfs(inDeg, adj, arr);
        if(n != arr.size()) return new int[]{};
        if(n == arr.size()){
            int idx = 0;
            for(int ele : arr){
                ans[idx++] = ele;
            }
        }
        return ans;
    }
}