class Solution {

    boolean findEmptyCell(char[][] board, int[]emptyCell){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    emptyCell[0]=i;
                    emptyCell[1]=j;
                    return true;
                }
            }
        }
        // There is no empty cell available
        return false;
    }
    public boolean isSafe(char[][] board,int rowIndex,int colIndex,int val){
        // for column checking 
        for(int col=0;col<9;col++){
            if(board[rowIndex][col]==val){
                return false;
            }
        }
        // for row cheking 
        for(int row=0;row<9;row++){
            if(board[row][colIndex]==val){
                return false;
            }
        }
        // 3 * 3 matrix checking 
        int pRIdx=rowIndex-rowIndex%3;
        int pCIdx=colIndex-colIndex%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int currRow=i+pRIdx;
                int currCol=j+pCIdx;
                if(board[currRow][currCol]==val){
                    return false;
                }
            }
        }
        return true;


    }
    public boolean solveSudokuHelper(char[][] board){
         int[] emptyCell=new int[2];
         if(!findEmptyCell(board,emptyCell)){
            return true;
         }
        int rowIndex=emptyCell[0];
        int colIndex=emptyCell[1];
        for(int i=1;i<=9;i++){
            char val=(char) (i+'0');
            if(isSafe(board,rowIndex,colIndex,val)){
                board[rowIndex][colIndex]=val;
                if(solveSudokuHelper(board)==true) return true;
                board[rowIndex][colIndex]='.';
            }
        }
        return false;

    }
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
}