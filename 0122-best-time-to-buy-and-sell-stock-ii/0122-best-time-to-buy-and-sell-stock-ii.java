class Solution {
    public int maxProfit(int[] prices) {
        int sum=0;
        int minDay=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){// 7 1 5 3 6 4
            if(minDay>prices[i]){
                minDay=prices[i];
            }else{
                sum+=prices[i]-minDay;
                minDay=prices[i];
            }

        }
        if(sum==0) return 0;
        else return sum;
    }
}


