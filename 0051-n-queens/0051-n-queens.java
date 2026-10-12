class Solution {
    
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        solve(board, 0, n);

        return ans;
    }

    void solve(char[][] board, int row, int n) {
        
        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++)
                temp.add(new String(board[i]));

            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (safe(board, row, col, n)) {
                board[row][col] = 'Q';

                solve(board, row + 1, n);

                board[row][col] = '.';
            }
        }
    }

    boolean safe(char[][] board, int row, int col, int n) {

        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}