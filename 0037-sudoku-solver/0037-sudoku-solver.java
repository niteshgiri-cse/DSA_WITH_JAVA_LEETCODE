class Solution {

    public boolean findEmptyCell(char[][] board, int[] emptyCell) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    //store empty cel ki row
                    emptyCell[0] = i;
                    emptyCell[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSafeToPlace(char[][] board, char charValue, int rowIndex, int colIndex) {

        //rules:
        // check for horizontal and same row
        for (int col = 0; col < 9; col++) {
            if (board[rowIndex][col] == charValue) {
                return false;
            }
        }

        //check for vertical and same colum
        for (int row = 0; row < 9; row++) {
            if (board[row][colIndex] == charValue) {
                return false;
            }
        }

        // check for 3*3 wall sub box
        /// formula for find starting index
        int startRow = rowIndex - rowIndex % 3;
        int startCol = colIndex - colIndex % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int actualRow = startRow + i;
                int actualCol = startCol + j;

                if (board[actualRow][actualCol] == charValue) {
                    return false;
                }
            }
        }

        // safe to place
        return true;
    }

    public boolean solveSudokoHelper(char[][] board) {

        int[] emptyCell = new int[2];

        if (!findEmptyCell(board, emptyCell)) {
            // agar empty nahi hoga tab
            return true;
        }

        //if let say i found a empty cell
        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        for (int value = 1; value <= 9; value++) {

            char charValue = (char) (value + '0');

            if (isSafeToPlace(board, charValue, rowIndex, colIndex)) {

                // safe hai to place kar do
                board[rowIndex][colIndex] = charValue;

                //baki recursion sambhal lega
                if (solveSudokoHelper(board) == true) {
                    return true;
                }

                //agar recursion sovle nahi kar paaya,or waps aa gya
                //current value ko undo karo or backtracking wala step karo
                board[rowIndex][colIndex] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        solveSudokoHelper(board);
    }
}