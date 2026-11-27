class Solution {
    public boolean helper(char[][] board,int ridx,int cidx,int val){
        //for horizontal check
         for(int col=0;col<9;col++){
            if(col!=cidx && board[ridx][col]==val){
                return false;
            }
         }
         //vertical check
         for(int row=0;row<9;row++){
            if(row!=ridx && board[row][cidx]==val){
                return false;
            }
         }
         // 3 3 boundary check 
         int pridx=ridx-ridx%3;
         int pcidx=cidx-cidx%3;
         for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int curRow=i+pridx;
                int curCol=j+pcidx;
                if((curRow!=ridx || curCol!=cidx) && board[curRow][curCol]==val){
                    return false;
                }
            }
         }
         return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch!='.'){
                    if(!helper(board,i,j,ch)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}