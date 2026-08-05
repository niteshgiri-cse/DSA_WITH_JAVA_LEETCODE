class Solution {
    public boolean findEmptyCell(char[][]board,int[]emptyCell){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    emptyCell[0]=i;
                    emptyCell[1]=j;
                    return true;
                }
            }
        }
        ///if no cell empty 
        return false;
    }

    public boolean isSafe(char[][]board,int value,int rowIndex,int colIndex){
        // rules to check 
        //same horizontal line 
        for(int col=0;col<9;col++){
            if(board[rowIndex][col]==value){
                return false;
            }
        }
        //same vertical line
        for(int row=0;row<9;row++){
             if(board[row][colIndex]==value){
                return false;
            }
        } 
        // check inside 3*3 matrix 
        int row=rowIndex-rowIndex%3;
        int col=colIndex-colIndex%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int startRow=row+i;
                int startCol=col+j;
                if(board[startRow][startCol]==value){
                    return false;
                }
            }
        }
        // value rakhna possible hai tab
        return true;

    }
   public boolean solveSudokuHelper(char[][]board){

    int [] emptyCell=new int[2];
    if(!findEmptyCell(board,emptyCell)){
        return true;
    }
    int rowIndex=emptyCell[0];
    int colIndex=emptyCell[1];

    for(int value=1;value<=9;value++){
        char currValue=(char) (value+'0');
        if(isSafe(board,currValue,rowIndex,colIndex)){
            board[rowIndex][colIndex]=currValue;
            if(solveSudokuHelper(board)==true){
                return true;
            }
            board[rowIndex][colIndex]='.';
        }
    }
    // sare value check karne ke bad bhi nahi huwa to 
    return false;

   }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
}