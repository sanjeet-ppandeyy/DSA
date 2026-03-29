import java.util.*;

class Triplet implements Comparable<Triplet>{
    int row;
    int col;
    int dist;

    Triplet(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
    public int compareTo(Triplet t){
        return Integer.compare(this.dist,t.dist);
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int [][] effort = new int[m][n];
        for (int i=0; i<m; i++) Arrays.fill(effort[i],Integer.MAX_VALUE);
        effort[0][0] = 0;

        int[] r = {-1,0,1,0};
        int[] c = {0,-1,0,1};

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while (pq.size() > 0) {
            Triplet top = pq.remove();
            int row = top.row, col = top.col, dist = top.dist;
            for (int i = 0; i < 4; i++) {
                int newRow = row + r[i];
                int newCol = col + c[i];
                if(newRow<0 || newCol<0 || newRow>m-1 || newCol>n-1) continue;
                int e = Math.abs(heights[row][col] - heights[newRow][newCol]);
                e = Math.max(e, dist);
                if (e < effort[newRow][newCol]) {
                    effort[newRow][newCol] = e;
                    pq.add(new Triplet(newRow, newCol, e));
                }
            }
        }
        return effort[m-1][n-1];
    }
}

