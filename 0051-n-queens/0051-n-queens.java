import java.util.*;

class Solution {

    static boolean isSafeToPlace(int rowIndex, int colIndex, int n, char[][] board) {
        int row = rowIndex;
        int col = colIndex;

        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            // row Index me koi change nahi karna h
            // col index ki value zero tak travel karegi
            col--;
        }

        // check left upper diagnol
        row = rowIndex;
        col = colIndex;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {   // Fixed == instead of =
                return false;
            }
            row = row - 1;
            col = col - 1;
        }

        //check left lower diagnol
        row = rowIndex;
        col = colIndex;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row = row + 1;
            col = col - 1;
        }

        // else
        return true;
    }

    static void solve(char[][] board, int n, int colIndex, List<List<String>> ans) {

        // base case
        if (colIndex >= n) {
            // iska mtlb-> board pr mereko ek valid arrangement milgyi h
            // iss valid arrangement ko ans me store karlo
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {      // Fixed 9 -> 0
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Ak case main solve karta hu, baaki recursion sombhal lega
        // current column ke har cell par jaake ya fer current column k har row par jaakar
        // Queen place karuga an rest recursion ko dedunga solve karne ke liye
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {

            if (isSafeToPlace(rowIndex, colIndex, n, board)) {   

                board[rowIndex][colIndex] = 'Q';                

                solve(board, n, colIndex + 1, ans);

                // important -> undo ya fer Backtracking wala step
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int colIndex = 0;

        List<List<String>> ans = new ArrayList<>();

        solve(board, n, colIndex, ans);

        return ans;
    }
}