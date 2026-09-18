class Solution {
    public boolean isValid(int row, int col, char[][] board, char num) {
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == num) return false;
        }
        for(int j=0;j<9;j++){
            if(board[row][j] == num) return false;
        }
        int sRow = row/3*3;
        int sCol = col/3*3;
        for(int i=sRow; i<sRow+3; i++){
            for(int j=sCol; j<sCol+3; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
    public void solve(char[][] board, int row, int col, char[][] arr) {
        if(row == 9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    arr[i][j] = board[i][j];
                }
            }
        }
        else if(board[row][col] != '.') {
            if(col != 8) solve(board, row, col+1,arr);
            else solve(board, row+1, 0,arr);
        }else{
            for(char ch='1'; ch<='9';ch++){
                if (isValid(row, col, board, ch)) {
                    board[row][col] = ch;
                    if(col != 8) solve(board, row, col+1,arr);
                    else solve(board, row+1, 0,arr);
                    board[row][col] = '.';
                }
            }
        }
    }
    public void solveSudoku(char[][] board) {
        char[][] arr = new char[9][9];
        solve(board, 0, 0, arr);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = arr[i][j];
            }
        }
    }
}