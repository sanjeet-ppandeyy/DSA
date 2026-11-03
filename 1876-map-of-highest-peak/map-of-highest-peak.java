import java.util.*;
class Pair {
    int first;
    int second;
    int third;

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int[][] highestPeak(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    res[i][j] = 0;
                }
            }
        }
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int row = p.first;
            int col = p.second;
            int steps = p.third;

            for (int i = 0; i < 4; i++) {
                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];
                if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && res[newRow][newCol] == -1) {
                    res[newRow][newCol] = steps + 1;
                    q.add(new Pair(newRow, newCol, steps + 1));
                }
            }
        }
        return res;
    }
}