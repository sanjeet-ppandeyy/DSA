class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i][n-1] = '.';
        }
        for (int j = 0 ; j < n; j++) {
            grid[0][j] = '.';
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] != '.') grid[i][j] = '#';
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
            }
            ans.add(sb.toString());
        }
        String[] res = new String[ans.size()];
       for (int i = 0; i < ans.size(); i++) {
           res[i] = ans.get(i);
       }
       return res;
    }
}