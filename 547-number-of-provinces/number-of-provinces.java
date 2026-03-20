class Solution {
    public void bfs(int i, boolean[] visit, int[][] isConnected){
        int n = isConnected.length;
        visit[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int top = q.remove();
            for(int j=0; j<n; j++){
                if(isConnected[top][j] == 1 && !visit[j]){
                    q.add(j);
                    visit[j] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visit[i]){
                bfs(i,visit,isConnected);
                count++;
            }
        }
        return count;
    }
}