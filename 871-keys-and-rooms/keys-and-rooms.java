class Solution {
    public void bfs(boolean[] visited,List<List<Integer>> rooms){
        int n = rooms.size();
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(q.size()>0){
            int top = q.remove();
            List<Integer> keys = rooms.get(top);
            for(int j : keys){
                if(!visited[j]){
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        bfs(visited,rooms);
        for(int i=0; i<n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}