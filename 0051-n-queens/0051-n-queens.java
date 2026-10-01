class Solution {
    public boolean isSafe(int colIndex,int rowIndex,char [][] board,int n){
        int row=rowIndex;
        int col=colIndex;
    //for horizontal check 
    while(col>=0){
        if(board[row][col]=='Q'){
            return false;
        }
        col--;
    }
    // for digonal check 
   row=rowIndex;
    col=colIndex; 
    while(row>=0 && col>=0){
         if(board[row][col]=='Q'){
            return false;
        }
        row--;
        col--;       
    }

    row=rowIndex;
    col=colIndex; 
    // for lower diagonal check
    while(row<n && col>=0){
        if(board[row][col]=='Q'){
            return false;
        }
        row++;
        col--;  
    }
    return true;

    }

    public void solve(char[][] board,int colIndex,int n,List<List<String>> ans){
    
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
        if(isSafe(colIndex,rowIndex,board,n)){
        board[rowIndex][colIndex]='Q';
        solve(board,colIndex+1,n,ans);
        board[rowIndex][colIndex]='.';
        }
    }




    }
    public List<List<String>> solveNQueens(int n) {
    char [][] board=new char[n][n]; 
    List<List<String>> ans=new ArrayList<>();
    for(int i=0;i<n;i++){
        Arrays.fill(board[i],'.');
    }
    int colIndex=0;
    solve(board,colIndex,n,ans);
    return ans;
    }
}