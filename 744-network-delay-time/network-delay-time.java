class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        for(int x=1; x<n; x++){
            for(int i=0; i<times.length; i++){
                int u = times[i][0];
                int v = times[i][1];
                int w = times[i][2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w; 
            }
        }
        int max = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max,dist[i]);
        }
        return max;
    }
}