class Solution {
    public boolean helper(char[][] board,int r,int c,int index,String word){
        if(index==word.length()){
            return true;
        }

        if(r<0 || c<0 || r>=board.length|| c>=board[0].length || board[r][c]!=word.charAt(index)){
            return false;
        }
        char ch=board[r][c];
        board[r][c]='#';
        boolean found =
            helper(board, r + 1, c, index + 1, word) ||
            helper(board, r - 1, c, index + 1, word) ||
            helper(board, r, c + 1, index + 1, word) ||
            helper(board, r, c - 1, index + 1, word);
            board[r][c]=ch;
        return found;


    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(helper(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
}