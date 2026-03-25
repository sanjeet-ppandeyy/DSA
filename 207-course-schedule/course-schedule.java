class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        int [] indegree = new int[n];
        for (int i=0; i<pre.length; i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(a).add(b);
            indegree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (q.size()>0){
            int top = q.remove();
            ans.add(top);
            for (int ele : adj.get(top)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }
        if (ans.size()==n) return true;
        return false;
    }
}