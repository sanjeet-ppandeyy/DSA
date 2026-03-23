class Solution {
    public void dfs(int i, boolean[] visit, int[][] isConnected) {
        visit[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                dfs(j,visit,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, visit, isConnected);
                count++;
            }
        }
        return count;
    }
}