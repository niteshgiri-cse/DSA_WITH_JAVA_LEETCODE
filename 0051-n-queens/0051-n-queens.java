class Solution {
    public boolean isSafe(char[][]board,int rowIndex,int colIndex,int n){
        int row=rowIndex;
        int col=colIndex;
        
        //for horizontal chacking
        while(col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            col--;
        }
        //for upper diagonal checking
        row=rowIndex;
        col=colIndex;
        while(col>=0 && row>=0){
             if(board[row][col]=='Q'){
                return false;
            }
            col--;
            row--;
        }
        //for lower diagonal checking
        
        row=rowIndex;
        col=colIndex;
        while(row<n && col>=0){
              if(board[row][col]=='Q'){
                return false;
            }
            row++;
            col--;
        }
        // else 
        return true;        

    }
    public void solve(char[][]board,int colIndex,int n, List<List<String>> ans){
        //base case
        if(colIndex>=n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int rowIndex=0;rowIndex<n;rowIndex++){
            if(isSafe(board,rowIndex,colIndex,n)){
            board[rowIndex][colIndex]='Q';
            solve(board,colIndex+1,n,ans);
            board[rowIndex][colIndex]='.';
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
        int colIndex=0;
        for(int i=0;i<n;i++)
        Arrays.fill(board[i],'.');

        solve(board,colIndex,n,ans);
        return ans;
    }
}