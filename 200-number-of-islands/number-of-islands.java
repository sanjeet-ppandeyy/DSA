class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while (!q.isEmpty()) {
            Pair top = q.remove();
            int row = top.row;
            int col = top.col;
            //top row-1,col
            if (row > 0) {
                if (grid[row - 1][col] == '1' && !vis[row - 1][col]) {
                    q.add(new Pair(row - 1, col));
                    vis[row - 1][col] = true;
                }
            }
            //bottom row+1,col
            if (row + 1 < m) {
                if (grid[row + 1][col] == '1' && !vis[row + 1][col]) {
                    q.add(new Pair(row + 1, col));
                    vis[row + 1][col] = true;
                }
            }
            //left row,col-1
            if (col > 0) {
                if (grid[row][col - 1] == '1' && !vis[row][col - 1]) {
                    q.add(new Pair(row, col - 1));
                    vis[row][col - 1] = true;
                }
            }
            //right row,col+1
            if (col + 1 < n) {
                if (grid[row][col + 1] == '1' && !vis[row][col + 1]) {
                    q.add(new Pair(row, col + 1));
                    vis[row][col + 1] = true;
                }
            }
        }
    }
}