class Solution {
    List<List<String>> res;

    public boolean isQueenSafe(boolean arr[][], int row, int col) {
        //VERTICAL
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == true) {
                return false;
            }
        }

        //UPPER RIGHT DIAGONAL
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == true) {
                return false;
            }
        }

        //UPPER LEFT DIAGONAL
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == true) {
                return false;
            }
        }

        return true;
    }

    public void printNQueens(boolean[][] board, int row) {
        if (row == board.length) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            res.add(ans);
            return;
        }

        for (int col= 0; col < board.length; col++) {
            if (isQueenSafe(board, row, col) == true) {
                board[row][col] = true;
                printNQueens(board, row + 1);
                board[row][col] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean board[][] = new boolean[n][n];

        printNQueens(board, 0);
        return res;
    }
}
