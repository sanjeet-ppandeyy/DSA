class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board  = new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nqueen(0,board,ans);
        return ans;
    }

    private void nqueen(int row, char[][] board, List<List<String>> ans) {
        int n = board.length;
        if(row == n){
            List<String> list = new ArrayList<>();
            for (int i=0; i<n; i++){
                String str = "";
                for (int j=0; j<n; j++){
                    str += board[i][j];
                }
                list.add(str);
            }
            ans.add(list);
            return;
        }
        for (int col=0; col<n; col++){
            if(canQueenBePlaced(row,col,board)){
                board[row][col] = 'Q';
                nqueen(row+1,board,ans);
                board[row][col] = '.';
            }
        }
    }
    public boolean canQueenBePlaced(int row, int col, char[][] board){
        int n = board.length;
        //Check column
        int i = row-1;
        while (i>=0){
            if (board[i][col] == 'Q') return false;
            i--;
        }
        //Check lef digonal
        i=row-1;
        int j = col-1;
        while (i>=0 && j>=0){
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        //Check right digonal
        i=row-1;
        j=col+1;
        while (i>=0 && j<n){
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}