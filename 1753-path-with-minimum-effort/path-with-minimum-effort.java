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
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while (pq.size() > 0){
            Triplet top = pq.remove();
            int row = top.row, col = top.col, dist = top.dist;

            if(row > 0){ // going up row-1
                int e = Math.abs(heights[row][col] - heights[row-1][col]);
                e = Math.max(e,dist);
                if(e < effort[row-1][col]){
                    effort[row-1][col] = e;
                    pq.add(new Triplet(row-1,col,e));
                }
            }
            if(col > 0){ // going left col-1
                int e = Math.abs(heights[row][col] - heights[row][col-1]);
                e = Math.max(e,dist);
                if(e < effort[row][col-1]){
                    effort[row][col-1] = e;
                    pq.add(new Triplet(row,col-1,e));
                }
            }
            if(row < m-1){ // going down col-1
                int e = Math.abs(heights[row][col] - heights[row+1][col]);
                e = Math.max(e,dist);
                if(e < effort[row+1][col]){
                    effort[row+1][col] = e;
                    pq.add(new Triplet(row+1,col,e));
                }
            }
            if(col < n-1){ // going Right col-1
                int e = Math.abs(heights[row][col] - heights[row][col+1]);
                e = Math.max(e,dist);
                if(e < effort[row][col+1]){
                    effort[row][col+1] = e;
                    pq.add(new Triplet(row,col+1,e));
                }
            }
        }
        return effort[m-1][n-1];
    }
}

