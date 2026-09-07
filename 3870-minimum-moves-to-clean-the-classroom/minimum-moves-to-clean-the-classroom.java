class State{
    int r;
    int c;
    int energy;
    int mask;
    State(int r, int c, int energy, int mask) {
        this.r = r;
        this.c = c;
        this.energy = energy;
        this.mask = mask;
    }
}
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int maxEnergy = energy;
        char[][] grid = new char[m][n];
        int sr = 0;
        int sc = 0;
        int[][] letterpositin = new int[m][n];
        int position = 0;
        int letter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if(ch == 'S'){
                    sr = i;
                    sc = j;
                }else if(ch == 'L'){
                    letterpositin[i][j] = position++;
                    letter++;
                }
                grid[i][j] = ch;
            }
        }
        if(letter == 0) return 0;
        int totalMask = (1<<letter)-1;
        int moves = 0;

        boolean[][][][] visited = new boolean[m][n][energy+1][1 << letter];
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        Queue<State> q = new LinkedList<>();
        q.add(new State(sr, sc, energy, 0));
        visited[sr][sc][energy][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                State top = q.remove();
                if(top.mask == totalMask) return moves;
                int r = top.r;
                int c = top.c;
                int e = top.energy;
                e--;
                if (e < 0) continue;
                int curr = top.mask;
                for (int d = 0; d < dir.length; d++) {
                    int newR = r + dir[d][0];
                    int newC = c + dir[d][1];
                    if(newR < 0 || newR >= m || newC < 0 || newC >= n) continue;
                    if(grid[newR][newC] == 'X') continue;
                    int newMask = curr;
                    int newEnergy = e;
                    if(grid[newR][newC] == 'L'){
                        int k = letterpositin[newR][newC];
                        newMask |= (1<<k);
                    }
                    if(grid[newR][newC] == 'R') newEnergy = maxEnergy;
                    if(!visited[newR][newC][newEnergy][newMask]){
                        q.add(new State(newR, newC, newEnergy, newMask));
                        visited[newR][newC][newEnergy][newMask] = true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}