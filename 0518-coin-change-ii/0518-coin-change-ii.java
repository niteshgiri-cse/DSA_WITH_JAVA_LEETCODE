class Solution {
    public int solve(int[] coins,int idx,int amount,int[][]dp){
        if(amount==0) return 1;
        if(idx==coins.length) return 0;

        if(dp[idx][amount]!=-1) return dp[idx][amount];

        int skip=solve(coins,idx+1,amount,dp);
        int take=0;
        if(coins[idx]<=amount){
            take=solve(coins,idx,amount-coins[idx],dp);
        }
        return dp[idx][amount]=take+skip;
    }
    public int change(int amount, int[] coins) {
        int [][] dp=new int[coins.length][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans=solve(coins,0,amount,dp);
    
        return ans;
    }
}