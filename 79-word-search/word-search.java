class Solution {
    public boolean helper(int i, int j, char[][] arr,String word,boolean[][] vis,int idx){
        int m = arr.length;
        int n = arr[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || arr[i][j] != word.charAt(idx)) return false;

        if(idx == word.length()-1) return true;

        vis[i][j]=true;

        boolean found = helper(i + 1, j, arr, word, vis, idx + 1) ||
                        helper(i, j + 1, arr, word, vis, idx + 1) ||
                        helper(i, j - 1, arr, word, vis, idx + 1) ||
                        helper(i - 1, j, arr, word, vis, idx + 1);

        vis[i][j]=false;
        return found;
    }


    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(i,j,board,word,vis,0)) return true;
            }
        }
        return false;
    }
}