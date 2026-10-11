class Solution {
    public boolean helper(int r,int c,int[][]grid,int n,int move){
        if(r<0 || c<0 || r>=grid.length|| c>=grid[0].length || grid[r][c]!=move){
            return false;
        }
        if(move==n*n-1){
            return true;
        }
        boolean ans1 = helper(r-2, c+1, grid, n, move+1);
        boolean ans2 = helper(r-1, c+2, grid, n, move+1);
        boolean ans3 = helper(r+1, c+2, grid, n, move+1);
        boolean ans4 = helper(r+2, c+1, grid, n, move+1);
        boolean ans5 = helper(r-2, c-1, grid, n, move+1);
        boolean ans6 = helper(r+1, c-2, grid, n, move+1);
        boolean ans7 = helper(r-1, c-2, grid, n, move+1);
        boolean ans8 = helper(r+2, c-1, grid, n, move+1);
            return ans1||ans2||ans3||ans4|| ans5|| ans6|| ans7|| ans8;
             
        
    }
    public boolean checkValidGrid(int[][] grid) {
       return helper(0,0,grid,grid.length,0);

    }
}